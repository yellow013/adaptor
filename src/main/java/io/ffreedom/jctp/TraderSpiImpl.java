package io.ffreedom.jctp;

import ctp.thostapi.CThostFtdcInputOrderActionField;
import ctp.thostapi.CThostFtdcInputOrderField;
import ctp.thostapi.CThostFtdcInstrumentField;
import ctp.thostapi.CThostFtdcOrderActionField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcQryInstrumentField;
import ctp.thostapi.CThostFtdcQrySettlementInfoField;
import ctp.thostapi.CThostFtdcQryTradingAccountField;
import ctp.thostapi.CThostFtdcReqUserLoginField;
import ctp.thostapi.CThostFtdcRspAuthenticateField;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspUserLoginField;
import ctp.thostapi.CThostFtdcSettlementInfoField;
import ctp.thostapi.CThostFtdcTradeField;
import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.CThostFtdcTradingAccountField;
import ctp.thostapi.CThostFtdcUserLogoutField;
import io.ffreedom.jctp.base.BaseTraderSpiImpl;
import io.ffreedom.jctp.bean.CtpUserInfo;

import static io.ffreedom.jctp.base.CtpRspValidator.validateRspInfo;

public class TraderSpiImpl extends BaseTraderSpiImpl {

	private CtpUserInfo userInfo;
	private Gateway gateway;

	TraderSpiImpl(CThostFtdcTraderApi traderApi, Gateway gateway, CtpUserInfo userInfo) {
		super(traderApi);
		this.gateway = gateway;
		this.userInfo = userInfo;
	}

	@Override
	public void OnFrontConnected() {
		logger.info("Callback TraderSpiImpl OnFrontConnected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(userInfo.getBrokerId());
		field.setUserID(userInfo.getUserId());
		field.setPassword(userInfo.getPassword());
		field.setUserProductInfo("JAVA_API_TEST");
		traderApi.ReqUserLogin(field, 0);
		logger.info("ReqUserLogin OK");
	}

	@Override
	public void OnFrontDisconnected(int nReason) {
		logger.warn("OnFrontDisconnected -> Reason==[{}]", nReason);
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspUserLogin", pRspInfo);

		logger.info("OnRspUserLogin -> Login Success");
		CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
		qryTradingAccount.setBrokerID(userInfo.getBrokerId());
		qryTradingAccount.setCurrencyID(userInfo.getCurrencyId());
		qryTradingAccount.setInvestorID(userInfo.getInvestorId());
		traderApi.ReqQryTradingAccount(qryTradingAccount, 1);
		logger.info("ReqQryTradingAccount OK");

		CThostFtdcQrySettlementInfoField qrySettlementInfoField = new CThostFtdcQrySettlementInfoField();
		qrySettlementInfoField.setBrokerID(userInfo.getBrokerId());
		qrySettlementInfoField.setInvestorID(userInfo.getInvestorId());
		qrySettlementInfoField.setTradingDay(userInfo.getTradingDay());
		qrySettlementInfoField.setAccountID(userInfo.getAccountId());
		qrySettlementInfoField.setCurrencyID(userInfo.getCurrencyId());
		traderApi.ReqQrySettlementInfo(qrySettlementInfoField, 2);
		logger.info("ReqQrySettlementInfo OK");

		CThostFtdcQryInstrumentField qryInstrumentField = new CThostFtdcQryInstrumentField();
		traderApi.ReqQryInstrument(qryInstrumentField, 3);
		logger.info("ReqQryInstrument OK");
	}

	@Override
	public void OnRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspAuthenticate", pRspInfo);
	}

	@Override
	public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		validateRspInfo("OnRspUserLogout", pRspInfo);
	}

	@Override
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspQryTradingAccount", pRspInfo);

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
		validateRspInfo("OnRspQrySettlementInfo", pRspInfo);

		if (pSettlementInfo != null)
			logger.info("OnRspQrySettlementInfo -> \n {}", pSettlementInfo.getContent());
		else
			logger.info("OnRspQrySettlementInfo return null");
	}

	@Override
	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspQryInstrument", pRspInfo);
		
		if (pInstrument != null)
			logger.info("OnRspQryInstrument -> InstrumentID==[{}]", pInstrument.getInstrumentID());
		else
			logger.info("OnRspQryInstrument return null");
	}

	@Override
	public void OnRtnOrder(CThostFtdcOrderField pOrder) {
		// TODO Auto-generated method stub
	}

	@Override
	public void OnRtnTrade(CThostFtdcTradeField pTrade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		validateRspInfo("OnRspOrderInsert", pRspInfo);
	}

	@Override
	public void OnRspOrderAction(CThostFtdcInputOrderActionField pInputOrderAction, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		validateRspInfo("OnRspOrderAction", pRspInfo);
	}

	@Override
	public void OnErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo) {
		validateRspInfo("OnErrRtnOrderInsert", pRspInfo);
	}

	@Override
	public void OnErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
		validateRspInfo("OnErrRtnOrderAction", pRspInfo);
	}

	@Override
	public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
	}

}