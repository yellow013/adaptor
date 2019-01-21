package io.ffreedom.jctp.gateway;

import java.io.File;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.util.FileUtil;
import io.ffreedom.common.utils.ThreadUtil;
import io.ffreedom.jctp.gateway.config.TdApiConfig;
import io.ffreedom.jctp.jni.td.CThostFtdcTraderApi;

public class TdApi {

	private Logger log = LoggerFactory.getLogger(getClass());

	private volatile CThostFtdcTraderApi cThostFtdcTraderApi;

	private volatile boolean isConnecting = false; // 是否正在连接中
	private volatile boolean isConnected = false; // 连接状态
	private volatile boolean isLogin = false; // 登陆状态

	private String tdAddress;
	private String brokerId;
	private String userId;
	private String password;
	private String authCode;
	private String userProductInfo;
	private String gatewayId;

	private TdSpi tdSpi;

	public TdApi(String gatewayId, TdSpi tdSpi, TdApiConfig config) {
		this.gatewayId = gatewayId;
		this.tdSpi = tdSpi;
		this.tdAddress = config.getTdAddress();
		this.brokerId = config.getBrokerId();
		this.userId = config.getUserId();
		this.password = config.getPassword();
		this.authCode = config.getAuthCode();
	}

	/**
	 * 连接
	 */
	public synchronized void connect() {
		if (isConnected() || isConnecting)
			return;
		if (cThostFtdcTraderApi != null) {
			cThostFtdcTraderApi.RegisterSpi(null);
			// 由于CTP底层原因，部分情况下不能正确执行Release
			ThreadUtil.startNewThread(() -> apiRelease(), gatewayId + "-TdApiReleaseThread-" + LocalDateTime.now());
			ThreadUtil.sleep(2000);
			isConnecting = false;
			isConnected = false;
			isLogin = false;
		}

		log.warn("{} 交易接口实例初始化", gatewayId);
		String envTmpDir = System.getProperty("java.io.tmpdir");
		String tempFilePath = envTmpDir + File.separator + "jctp" + File.separator + "TEMP" + File.separator + "TD_"
				+ gatewayId;
		File tempFile = new File(tempFilePath);
		FileUtil.createMissingParentDirectories(tempFile);

		log.info("{} 使用临时文件夹{}", gatewayId, tempFile.getParentFile().getAbsolutePath());
		cThostFtdcTraderApi = CThostFtdcTraderApi.CreateFtdcTraderApi(tempFile.getAbsolutePath());
		cThostFtdcTraderApi.RegisterSpi(tdSpi);
		cThostFtdcTraderApi.RegisterFront(tdAddress);
		isConnecting = true;
		cThostFtdcTraderApi.Init();
	}

	/**
	 * 关闭
	 */
	public synchronized void close() {
		if (cThostFtdcTraderApi != null) {
			log.info("{} TdApi close and release start.", gatewayId);
			cThostFtdcTraderApi.RegisterSpi(null);
			// 避免异步线程找不到引用
			// CThostFtdcTraderApi cThostFtdcTraderApiForRelease = cThostFtdcTraderApi;
			// 由于CTP底层原因，部分情况下不能正确执行Release
			ThreadUtil.startNewThread(() -> apiRelease(), gatewayId + "-TdApiReleaseThread-" + LocalDateTime.now());
			ThreadUtil.sleep(2000);
			cThostFtdcTraderApi = null;
			isConnecting = false;
			isConnected = false;
			isLogin = false;
			log.info("{} TdApi instance close and release end.", gatewayId);
			// 通知停止其他关联实例
		} else
			log.warn("{} TdApi instance is null.", gatewayId);
	}

	private void apiRelease() {
		try {
			log.info("{} TdApi release thread start...", gatewayId);
			cThostFtdcTraderApi.Release();
		} catch (Exception e) {
			log.error("{} TdApi release thread error...", gatewayId, e);
		}
	}

	/**
	 * 返回接口状态
	 * 
	 * @return
	 */
	boolean isConnected() {
		return isConnected;
	}

	void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	boolean isLogin() {
		return isLogin;
	}

	void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
