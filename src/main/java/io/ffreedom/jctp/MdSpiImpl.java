package io.ffreedom.jctp;

import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcMdSpi;
import ctp.thostapi.CThostFtdcReqUserLoginField;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspUserLoginField;

public class MdSpiImpl extends CThostFtdcMdSpi {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private CThostFtdcMdApi mdApi;
	private Set<String> instruementIdSet;

	MdSpiImpl(CThostFtdcMdApi mdApi, Set<String> instruementIdSet) {
		this.mdApi = mdApi;
		this.instruementIdSet = instruementIdSet;
	}

	@Override
	public void OnFrontConnected() {
		logger.info("Callback MdSpiImpl OnFrontConnected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(CtpInfo.BrokerId);
		field.setUserID(CtpInfo.UserId);
		field.setPassword(CtpInfo.Password);
		mdApi.ReqUserLogin(field, 0);
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
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
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null)
//			logger.info("OnRtnDepthMarketData -> InstrumentID==[{}] AskPrice1==[{}] BidPrice1==[{}]",
//					pDepthMarketData.getInstrumentID(), pDepthMarketData.getAskPrice1(),
//					pDepthMarketData.getBidPrice1());
			System.out.println("OnRtnDepthMarketData -> InstrumentID==[" + pDepthMarketData.getInstrumentID()
					+ "] AskPrice1==[" + pDepthMarketData.getAskPrice1() + "] BidPrice1==["
					+ pDepthMarketData.getBidPrice1() + "]");
		else
			// logger.info("OnRtnDepthMarketData return null");
			System.out.println("OnRtnDepthMarketData return null");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
	}

}