package io.ffreedom.jctp.gateway;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.util.FileUtil;
import io.ffreedom.jctp.gateway.config.MdSpiConfig;
import io.ffreedom.jctp.jni.md.CThostFtdcDepthMarketDataField;
import io.ffreedom.jctp.jni.md.CThostFtdcForQuoteRspField;
import io.ffreedom.jctp.jni.md.CThostFtdcMdApi;
import io.ffreedom.jctp.jni.md.CThostFtdcMdSpi;
import io.ffreedom.jctp.jni.md.CThostFtdcReqUserLoginField;
import io.ffreedom.jctp.jni.md.CThostFtdcRspInfoField;
import io.ffreedom.jctp.jni.md.CThostFtdcRspUserLoginField;
import io.ffreedom.jctp.jni.md.CThostFtdcSpecificInstrumentField;
import io.ffreedom.jctp.jni.md.CThostFtdcUserLogoutField;

/**
 * @author sun0x00@gmail.com
 */
public class MdSpi extends CThostFtdcMdSpi {

	Logger log = LoggerFactory.getLogger(MdSpi.class);

	private CtpGateway ctpGateway;
	private String mdAddress;
	private String brokerID;
	private String userID;
	private String password;
	private String gatewayID;
	private String gatewayName;

	private String tradingDayStr;

	private HashMap<String, String> contractExchangeMap;
	private HashMap<String, String> contractNameMap;
	private HashMap<String, Integer> preTickVolumeMap = new HashMap<>();

	MdSpi(CtpGateway ctpGateway, MdSpiConfig config) {

		this.ctpGateway = ctpGateway;
		this.mdAddress = config.getMdAddress();
		this.brokerID = config.getBrokerId();
		this.userID = config.getUserId();
		this.password = config.getPassword();
		this.gatewayID = config.getGatewayId();
		this.gatewayName = config.getGatewayName();

	}

	// 前置机联机回报
	@Override
	public void OnFrontConnected() {
		log.info(gatewayName + "行情接口前置机已连接");

		// 修改前置机连接状态为true
//		connectionStatus = true;
//		connectProcessStatus = false;
//		login();
		ctpGateway.onFrontConnected();
	}

	// 前置机断开回报
	@Override
	public void OnFrontDisconnected(int nReason) {
		log.info(gatewayName + "行情接口前置机已断开,Reason:" + nReason);
		
		ctpGateway.onFrontDisconnected(nReason);
	}

	// 登录回报
	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0) {
			log.info("{}OnRspUserLogin! TradingDay:{},SessionID:{},BrokerID:{},UserID:{}", gatewayName,
					pRspUserLogin.getTradingDay(), pRspUserLogin.getSessionID(), pRspUserLogin.getBrokerID(),
					pRspUserLogin.getUserID());
			// 修改登录状态为true
			this.loginStatus = true;
			tradingDayStr = pRspUserLogin.getTradingDay();
			log.info("{}行情接口获取到的交易日为{}", gatewayName, tradingDayStr);
			// 重新订阅之前的合约
			if (!ctpGateway.getSubscribedSymbols().isEmpty()) {
				String[] subscribedSymbolsArray = ctpGateway.getSubscribedSymbols()
						.toArray(new String[ctpGateway.getSubscribedSymbols().size()]);
				cThostFtdcMdApi.SubscribeMarketData(subscribedSymbolsArray, subscribedSymbolsArray.length + 1);
			}
		} else
			log.warn("{}行情接口登录回报错误! ErrorID:{},ErrorMsg:{}", gatewayName, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
	}

	// 心跳警告
	@Override
	public void OnHeartBeatWarning(int nTimeLapse) {
		log.warn(gatewayName + "行情接口心跳警告 nTimeLapse:" + nTimeLapse);
	}

	// 登出回报
	@Override
	public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		if (pRspInfo.getErrorID() != 0)
			log.info("{}OnRspUserLogout!ErrorID:{},ErrorMsg:{}", gatewayName, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
		else
			log.info("{}OnRspUserLogout!BrokerID:{},UserID:{}", gatewayName, pUserLogout.getBrokerID(),
					pUserLogout.getUserID());
		this.loginStatus = false;
	}

	// 错误回报
	@Override
	public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		log.info("{}行情接口错误回报!ErrorID:{},ErrorMsg:{},RequestID:{},isLast{}", gatewayName, pRspInfo.getErrorID(),
				pRspInfo.getErrorMsg(), nRequestID, bIsLast);
	}

	// 订阅合约回报
	@Override
	public void OnRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0)
			log.info("{} OnRspSubMarketData! 订阅合约成功:{}", gatewayName, pSpecificInstrument.getInstrumentID());
		else
			log.error("{} OnRspSubMarketData! 订阅合约失败,ErrorID:{} ErrorMsg:{}", gatewayName, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
	}

	// 退订合约回报
	@Override
	public void OnRspUnSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0)
			log.info("{} OnRspSubMarketData! 退订合约成功:{}", gatewayName, pSpecificInstrument.getInstrumentID());
		else
			log.error("{} OnRspSubMarketData! 退订合约失败,ErrorID:{} ErrorMsg:{}", gatewayName, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
	}

	// 合约行情推送
	@SuppressWarnings("unused")
	@Override
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null) {

			String symbol = pDepthMarketData.getInstrumentID();

			if (!contractExchangeMap.containsKey(symbol)) {
				log.warn("{} 收到合约 {}行情,但尚未获取到交易所信息,丢弃", gatewayName, symbol);
				return;
			}

			// 上期所 郑商所正常,大商所错误
			// TODO 大商所时间修正
			Long updateTime = Long.valueOf(pDepthMarketData.getUpdateTime().replaceAll(":", ""));
			Long updateMillisec = (long) pDepthMarketData.getUpdateMillisec();
			Long actionDay = Long.valueOf(pDepthMarketData.getActionDay());

			String updateDateTimeWithMS = (actionDay * 100 * 100 * 100 * 1000 + updateTime * 1000 + updateMillisec)
					+ "";

			LocalDateTime dateTime = LocalDateTime.parse(updateDateTimeWithMS,
					Constant.DT_FORMAT_WITH_MS_INT_FORMATTER);

			String exchange = contractExchangeMap.get(symbol);
			String rtSymbol = symbol + "." + exchange;
			String contractName = contractNameMap.get(symbol);
			String tickID = rtSymbol + "." + gatewayID;
			String tradingDay = tradingDayStr;
			String actionDayStr = pDepthMarketData.getActionDay();
			String actionTime = dateTime.toString();
			Integer status = 0;
			Double lastPrice = pDepthMarketData.getLastPrice();
			Integer volume = pDepthMarketData.getVolume();
			Integer lastVolume = 0;
			if (preTickVolumeMap.containsKey(tickID)) {
				lastVolume = volume - preTickVolumeMap.get(tickID);
			} else {
				lastVolume = volume;
			}
			preTickVolumeMap.put(tickID, volume);
			Double openInterest = pDepthMarketData.getOpenInterest();
			Long preOpenInterest = (long) pDepthMarketData.getPreOpenInterest();
			Double preClosePrice = pDepthMarketData.getPreClosePrice();
			Double preSettlePrice = pDepthMarketData.getPreSettlementPrice();
			Double openPrice = pDepthMarketData.getOpenPrice();
			Double highPrice = pDepthMarketData.getHighestPrice();
			Double lowPrice = pDepthMarketData.getLowestPrice();
			Double upperLimit = pDepthMarketData.getUpperLimitPrice();
			Double lowerLimit = pDepthMarketData.getLowerLimitPrice();
			Double bidPrice1 = pDepthMarketData.getBidPrice1();
			Double bidPrice2 = pDepthMarketData.getBidPrice2();
			Double bidPrice3 = pDepthMarketData.getBidPrice3();
			Double bidPrice4 = pDepthMarketData.getBidPrice4();
			Double bidPrice5 = pDepthMarketData.getBidPrice5();
			Double bidPrice6 = 0d;
			Double bidPrice7 = 0d;
			Double bidPrice8 = 0d;
			Double bidPrice9 = 0d;
			Double bidPrice10 = 0d;
			Double askPrice1 = pDepthMarketData.getAskPrice1();
			Double askPrice2 = pDepthMarketData.getAskPrice2();
			Double askPrice3 = pDepthMarketData.getAskPrice3();
			Double askPrice4 = pDepthMarketData.getAskPrice4();
			Double askPrice5 = pDepthMarketData.getAskPrice5();
			Double askPrice6 = 0d;
			Double askPrice7 = 0d;
			Double askPrice8 = 0d;
			Double askPrice9 = 0d;
			Double askPrice10 = 0d;
			Integer bidVolume1 = pDepthMarketData.getBidVolume1();
			Integer bidVolume2 = pDepthMarketData.getBidVolume2();
			Integer bidVolume3 = pDepthMarketData.getBidVolume3();
			Integer bidVolume4 = pDepthMarketData.getBidVolume4();
			Integer bidVolume5 = pDepthMarketData.getBidVolume5();
			Integer bidVolume6 = 0;
			Integer bidVolume7 = 0;
			Integer bidVolume8 = 0;
			Integer bidVolume9 = 0;
			Integer bidVolume10 = 0;
			Integer askVolume1 = pDepthMarketData.getAskVolume1();
			Integer askVolume2 = pDepthMarketData.getAskVolume2();
			Integer askVolume3 = pDepthMarketData.getAskVolume3();
			Integer askVolume4 = pDepthMarketData.getAskVolume4();
			Integer askVolume5 = pDepthMarketData.getAskVolume5();
			Integer askVolume6 = 0;
			Integer askVolume7 = 0;
			Integer askVolume8 = 0;
			Integer askVolume9 = 0;
			Integer askVolume10 = 0;

		} else
			log.warn("{}OnRtnDepthMarketData! 收到行情信息为空", gatewayName);

	}

	// 订阅期权询价
	public void OnRspSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		log.info("{}OnRspSubForQuoteRsp!", gatewayName);
	}

	// 退订期权询价
	public void OnRspUnSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		log.info("{}OnRspUnSubForQuoteRsp!", gatewayName);
	}

	// 期权询价推送
	public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {
		log.info("{}OnRspUnSubForQuoteRsp!", gatewayName);
	}

}