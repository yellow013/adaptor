package io.ffreedom.jctp;

import java.util.Iterator;
import java.util.Set;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcReqUserLoginField;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspUserLoginField;
import ctp.thostapi.CThostFtdcSpecificInstrumentField;
import io.ffreedom.common.queue.base.SCQueue;
import io.ffreedom.jctp.base.BaseMdSpiImpl;
import io.ffreedom.jctp.bean.CtpUserInfo;
import io.ffreedom.jctp.bean.RspMsg;

import static io.ffreedom.jctp.base.CtpRspValidator.validateRspInfo;

public class MdSpiImpl extends BaseMdSpiImpl {

	private CtpUserInfo userInfo;
	private Set<String> instruementIdSet;

	MdSpiImpl(CThostFtdcMdApi mdApi, CtpUserInfo userInfo, Set<String> instruementIdSet, SCQueue<RspMsg> inboundQueue) {
		super(mdApi);
		this.userInfo = userInfo;
		this.instruementIdSet = instruementIdSet;
	}

	@Override
	public void OnFrontConnected() {
		logger.info("Callback MdSpiImpl OnFrontConnected");
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField();
		userLoginField.setBrokerID(userInfo.getBrokerId());
		userLoginField.setUserID(userInfo.getUserId());
		userLoginField.setPassword(userInfo.getPassword());
		mdApi.ReqUserLogin(userLoginField, 0);
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspUserLogin", pRspInfo);
		if (pRspUserLogin != null) {
			logger.info("OnRspUserLogin -> Brokerid==[{}]", pRspUserLogin.getBrokerID());
		} else {
			logger.info("OnRspUserLogin return null");
			return;
		}
		String[] instruementId = new String[1];
		Iterator<String> iterator = instruementIdSet.iterator();
		while (iterator.hasNext()) {
			instruementId[0] = iterator.next().toString();
			mdApi.SubscribeMarketData(instruementId, 1);
			logger.info("SubscribeMarketData -> " + instruementId[0]);
		}
	}

	@Override
	public void OnRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspSubMarketData", pRspInfo);
		pSpecificInstrument.getInstrumentID();

	}

	@Override
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null) {
			logger.info(
					"OnRtnDepthMarketData -> InstrumentID==[{}] UpdateMillisec==[{}] UpdateTime==[{}] AskPrice1==[{}] BidPrice1==[{}]",
					pDepthMarketData.getInstrumentID(), pDepthMarketData.getUpdateMillisec(),
					pDepthMarketData.getUpdateTime(), pDepthMarketData.getAskPrice1(), pDepthMarketData.getBidPrice1());
		} else
			logger.info("OnRtnDepthMarketData return null");
	}

}