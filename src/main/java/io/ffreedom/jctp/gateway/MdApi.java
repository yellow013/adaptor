package io.ffreedom.jctp.gateway;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.util.FileUtil;
import io.ffreedom.jctp.jni.md.CThostFtdcMdApi;
import io.ffreedom.jctp.jni.md.CThostFtdcReqUserLoginField;

public class MdApi {

	private Logger log = LoggerFactory.getLogger(getClass());

	private CThostFtdcMdApi cThostFtdcMdApi;

	private boolean connectProcessStatus = false; // 避免重复调用
	private boolean connectionStatus = false; // 前置机连接状态
	private boolean loginStatus = false; // 登陆状态

	private MdSpi mdSpi;
	private String gatewayId;

	MdApi(MdSpi mdSpi, String gatewayId) {
		this.mdSpi = mdSpi;
		this.gatewayId = gatewayId;
	}

	/**
	 * 连接
	 */
	public synchronized void connect() {
		if (isConnected() || connectProcessStatus)
			return;
		if (connectionStatus) {
			login();
			return;
		}
		if (cThostFtdcMdApi != null) {
			cThostFtdcMdApi.RegisterSpi(null);
			// 由于CTP底层原因，部分情况下不能正确执行Release
			new Thread(() -> {
				try {
					log.warn("{} 行情接口异步释放Starting...", gatewayId);
					cThostFtdcMdApi.Release();
				} catch (Exception e) {
					log.error("{} 行情接口异步释放Error...", gatewayId, e);
				}
			}, gatewayId + "-MdApiReleaseThread" + LocalDateTime.now().format(Constant.DT_FORMAT_WITH_MS_INT_FORMATTER))
					.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			connectionStatus = false;
			loginStatus = false;
		}

		log.warn("{} 行情接口实例初始化", gatewayId);

		String envTmpDir = System.getProperty("java.io.tmpdir");
		String tempFilePath = envTmpDir + File.separator + "jctp" + File.separator + "TEMP" + File.separator + "MD_"
				+ gatewayId;
		File tempFile = new File(tempFilePath);
		FileUtil.createMissingParentDirectories(tempFile);

		log.info("{} 使用临时文件夹", gatewayId, tempFile.getParentFile().getAbsolutePath());

		cThostFtdcMdApi = CThostFtdcMdApi.CreateFtdcMdApi(tempFile.getAbsolutePath());
		cThostFtdcMdApi.RegisterSpi(mdSpi);
		cThostFtdcMdApi.RegisterFront(mdAddress);
		connectProcessStatus = true;
		cThostFtdcMdApi.Init();
	}

	/**
	 * 关闭
	 */
	public synchronized void close() {
		if (cThostFtdcMdApi != null) {
			log.warn("{} 行情接口实例开始关闭并释放", gatewayId);
			cThostFtdcMdApi.RegisterSpi(null);
			// 避免异步线程找不到引用
			CThostFtdcMdApi cThostFtdcMdApiForRelease = cThostFtdcMdApi;
			// 由于CTP底层原因，部分情况下不能正确执行Release
			new Thread(() -> {
				try {
					log.warn("{} 行情接口异步释放启动！", gatewayId);
					cThostFtdcMdApiForRelease.Release();
				} catch (Exception e) {
					log.error("{} 行情接口异步释放发生异常！", gatewayId, e);
				}
			}, gatewayId + "MdApiReleaseThread" + LocalDateTime.now().format(Constant.DT_FORMAT_WITH_MS_INT_FORMATTER))
					.start();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// nop
			}
			cThostFtdcMdApi = null;
			connectionStatus = false;
			loginStatus = false;
			connectProcessStatus = false;
			log.warn("{} 行情接口实例关闭并释放", gatewayId);
			// 通知停止其他关联实例
			ctpGateway.close();
		} else
			log.warn("{} 行情接口实例为null,无需关闭", gatewayId);
	}

	/**
	 * 返回接口状态
	 * 
	 * @return
	 */
	boolean isConnected() {
		return connectionStatus && loginStatus;
	}

	/**
	 * 订阅行情
	 * 
	 * @param rtSymbol
	 */
	void subscribe(String symbol) {
		if (isConnected()) {
			String[] symbolArray = new String[1];
			symbolArray[0] = symbol;
			cThostFtdcMdApi.SubscribeMarketData(symbolArray, 1);
		} else
			log.warn(gatewayId + "无法订阅行情,行情服务器尚未连接成功");
	}

	/**
	 * 退订行情
	 */
	void unsubscribe(String symbol) {
		if (isConnected()) {
			String[] symbolArray = new String[1];
			symbolArray[0] = symbol;
			cThostFtdcMdApi.UnSubscribeMarketData(symbolArray, 1);
		} else
			log.warn(gatewayId + "退订无效,行情服务器尚未连接成功");
	}

	void login() {
		if (StringUtils.isEmpty(brokerId) || StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
			log.error(gatewayId + " - brokerId or userId or password不允许为空");
			return;
		}
		// 登录
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField();
		userLoginField.setBrokerID(brokerId);
		userLoginField.setUserID(userId);
		userLoginField.setPassword(password);
		cThostFtdcMdApi.ReqUserLogin(userLoginField, 0);
	}

}
