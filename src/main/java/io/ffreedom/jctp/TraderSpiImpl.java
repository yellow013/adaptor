package io.ffreedom.jctp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcInstrumentField;
import ctp.thostapi.CThostFtdcQryInstrumentField;
import ctp.thostapi.CThostFtdcQrySettlementInfoField;
import ctp.thostapi.CThostFtdcQryTradingAccountField;
import ctp.thostapi.CThostFtdcReqUserLoginField;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspUserLoginField;
import ctp.thostapi.CThostFtdcSettlementInfoField;
import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.CThostFtdcTraderSpi;
import ctp.thostapi.CThostFtdcTradingAccountField;

public class TraderSpiImpl extends CThostFtdcTraderSpi {

	private CThostFtdcTraderApi traderApi;

	private Logger logger = LoggerFactory.getLogger(getClass());

	TraderSpiImpl(CThostFtdcTraderApi traderApi) {
		this.traderApi = traderApi;
	}

	@Override
	public void OnFrontConnected() {
		logger.info("Callback TraderSpiImpl OnFrontConnected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(CtpInfo.BrokerId);
		field.setUserID(CtpInfo.UserId);
		field.setPassword(CtpInfo.Password);
		field.setUserProductInfo("JAVA_API");
		traderApi.ReqUserLogin(field, 0);
		logger.info("ReqUserLogin OK");
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			logger.info("OnRspUserLogin -> ErrorID==[{}] ErrMsg==[{}]", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());
			return;
		}
		logger.info("OnRspUserLogin -> Login Success");
		CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
		qryTradingAccount.setBrokerID(CtpInfo.BrokerId);
		qryTradingAccount.setCurrencyID(CtpInfo.CurrencyId);
		qryTradingAccount.setInvestorID(CtpInfo.InvestorId);
		traderApi.ReqQryTradingAccount(qryTradingAccount, 1);
		logger.info("ReqQryTradingAccount OK");

		CThostFtdcQrySettlementInfoField qrySettlementInfoField = new CThostFtdcQrySettlementInfoField();
		qrySettlementInfoField.setBrokerID(CtpInfo.BrokerId);
		qrySettlementInfoField.setInvestorID(CtpInfo.InvestorId);
		qrySettlementInfoField.setTradingDay(CtpInfo.TradingDay);
		qrySettlementInfoField.setAccountID(CtpInfo.AccountId);
		qrySettlementInfoField.setCurrencyID(CtpInfo.CurrencyId);
		traderApi.ReqQrySettlementInfo(qrySettlementInfoField, 2);
		logger.info("ReqQrySettlementInfo OK");

		CThostFtdcQryInstrumentField qryInstrumentField = new CThostFtdcQryInstrumentField();
		traderApi.ReqQryInstrument(qryInstrumentField, 3);
		logger.info("ReqQryInstrument OK");
	}

	@Override
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			logger.info("OnRspQryTradingAccount -> ErrorID==[{}] ErrMsg==[{}]", pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			return;
		}
		if (pTradingAccount != null)
			logger.info("OnRspQryTradingAccount -> Balance==[{}] Available==[{}] WithdrawQuota==[{}] Credit==[{}]",
					pTradingAccount.getBalance(), pTradingAccount.getAvailable(), pTradingAccount.getWithdrawQuota(),
					pTradingAccount.getCredit());
		else
			logger.info("OnRspQryTradingAccount return null");
	}

	@Override
	public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			logger.info("OnRspQrySettlementInfo -> ErrorID==[{}] ErrMsg==[{}]", pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			return;
		}
		if (pSettlementInfo != null)
			logger.info("OnRspQrySettlementInfo -> \n {}", pSettlementInfo.getContent());
		else
			logger.info("OnRspQrySettlementInfo return null");
	}

	@Override
	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			logger.info("OnRspQryInstrument -> ErrorID==[{}] ErrMsg==[{}}", pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			return;
		}
		if (pInstrument != null)
			logger.info("OnRspQryInstrument -> InstrumentID==[{}]", pInstrument.getInstrumentID());
		else
			logger.info("OnRspQryInstrument return null");
	}

}