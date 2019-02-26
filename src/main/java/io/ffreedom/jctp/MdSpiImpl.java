package io.ffreedom.jctp;

import static io.ffreedom.jctp.base.CtpRspValidator.validateRspInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcMdSpi;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspUserLoginField;
import ctp.thostapi.CThostFtdcSpecificInstrumentField;

public class MdSpiImpl extends CThostFtdcMdSpi {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private Gateway gateway;

	MdSpiImpl(Gateway gateway) {
		this.gateway = gateway;
	}

	@Override
	public void OnFrontConnected() {
		logger.info("Callback MdSpiImpl OnFrontConnected");
		gateway.onMdFrontConnected();
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspUserLogin", pRspInfo);
		if (pRspUserLogin == null) {
			logger.info("OnRspUserLogin return null");
			return;
		}
		logger.info("OnRspUserLogin -> Brokerid==[{}] UserID==[{}]", pRspUserLogin.getBrokerID(),
				pRspUserLogin.getUserID());
		gateway.onMdRspUserLogin();
	}

	@Override
	public void OnRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspSubMarketData", pRspInfo);
		if (pSpecificInstrument == null) {
			logger.info("OnRspSubMarketData return null");
			return;
		}
		gateway.onRspSubMarketData(pSpecificInstrument.getInstrumentID());
	}

	@Override
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null)
			gateway.onRtnDepthMarketData(pDepthMarketData);
		else
			logger.info("OnRtnDepthMarketData return null");
	}

}