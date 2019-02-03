package io.ffreedom.jctp.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcAccountregisterField;
import ctp.thostapi.CThostFtdcBatchOrderActionField;
import ctp.thostapi.CThostFtdcBrokerTradingAlgosField;
import ctp.thostapi.CThostFtdcBrokerTradingParamsField;
import ctp.thostapi.CThostFtdcBulletinField;
import ctp.thostapi.CThostFtdcCFMMCTradingAccountKeyField;
import ctp.thostapi.CThostFtdcCFMMCTradingAccountTokenField;
import ctp.thostapi.CThostFtdcCancelAccountField;
import ctp.thostapi.CThostFtdcChangeAccountField;
import ctp.thostapi.CThostFtdcCombActionField;
import ctp.thostapi.CThostFtdcCombInstrumentGuardField;
import ctp.thostapi.CThostFtdcContractBankField;
import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcEWarrantOffsetField;
import ctp.thostapi.CThostFtdcErrorConditionalOrderField;
import ctp.thostapi.CThostFtdcExchangeField;
import ctp.thostapi.CThostFtdcExchangeMarginRateAdjustField;
import ctp.thostapi.CThostFtdcExchangeMarginRateField;
import ctp.thostapi.CThostFtdcExchangeRateField;
import ctp.thostapi.CThostFtdcExecOrderActionField;
import ctp.thostapi.CThostFtdcExecOrderField;
import ctp.thostapi.CThostFtdcForQuoteField;
import ctp.thostapi.CThostFtdcForQuoteRspField;
import ctp.thostapi.CThostFtdcInputBatchOrderActionField;
import ctp.thostapi.CThostFtdcInputCombActionField;
import ctp.thostapi.CThostFtdcInputExecOrderActionField;
import ctp.thostapi.CThostFtdcInputExecOrderField;
import ctp.thostapi.CThostFtdcInputForQuoteField;
import ctp.thostapi.CThostFtdcInputOptionSelfCloseActionField;
import ctp.thostapi.CThostFtdcInputOptionSelfCloseField;
import ctp.thostapi.CThostFtdcInputOrderActionField;
import ctp.thostapi.CThostFtdcInputOrderField;
import ctp.thostapi.CThostFtdcInputQuoteActionField;
import ctp.thostapi.CThostFtdcInputQuoteField;
import ctp.thostapi.CThostFtdcInstrumentCommissionRateField;
import ctp.thostapi.CThostFtdcInstrumentField;
import ctp.thostapi.CThostFtdcInstrumentMarginRateField;
import ctp.thostapi.CThostFtdcInstrumentOrderCommRateField;
import ctp.thostapi.CThostFtdcInstrumentStatusField;
import ctp.thostapi.CThostFtdcInvestUnitField;
import ctp.thostapi.CThostFtdcInvestorField;
import ctp.thostapi.CThostFtdcInvestorPositionCombineDetailField;
import ctp.thostapi.CThostFtdcInvestorPositionDetailField;
import ctp.thostapi.CThostFtdcInvestorPositionField;
import ctp.thostapi.CThostFtdcInvestorProductGroupMarginField;
import ctp.thostapi.CThostFtdcMMInstrumentCommissionRateField;
import ctp.thostapi.CThostFtdcMMOptionInstrCommRateField;
import ctp.thostapi.CThostFtdcNoticeField;
import ctp.thostapi.CThostFtdcNotifyQueryAccountField;
import ctp.thostapi.CThostFtdcOpenAccountField;
import ctp.thostapi.CThostFtdcOptionInstrCommRateField;
import ctp.thostapi.CThostFtdcOptionInstrTradeCostField;
import ctp.thostapi.CThostFtdcOptionSelfCloseActionField;
import ctp.thostapi.CThostFtdcOptionSelfCloseField;
import ctp.thostapi.CThostFtdcOrderActionField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcParkedOrderActionField;
import ctp.thostapi.CThostFtdcParkedOrderField;
import ctp.thostapi.CThostFtdcProductExchRateField;
import ctp.thostapi.CThostFtdcProductField;
import ctp.thostapi.CThostFtdcProductGroupField;
import ctp.thostapi.CThostFtdcQueryCFMMCTradingAccountTokenField;
import ctp.thostapi.CThostFtdcQueryMaxOrderVolumeField;
import ctp.thostapi.CThostFtdcQuoteActionField;
import ctp.thostapi.CThostFtdcQuoteField;
import ctp.thostapi.CThostFtdcRemoveParkedOrderActionField;
import ctp.thostapi.CThostFtdcRemoveParkedOrderField;
import ctp.thostapi.CThostFtdcReqQueryAccountField;
import ctp.thostapi.CThostFtdcReqRepealField;
import ctp.thostapi.CThostFtdcReqTransferField;
import ctp.thostapi.CThostFtdcRspAuthenticateField;
import ctp.thostapi.CThostFtdcRspInfoField;
import ctp.thostapi.CThostFtdcRspRepealField;
import ctp.thostapi.CThostFtdcRspTransferField;
import ctp.thostapi.CThostFtdcRspUserLoginField;
import ctp.thostapi.CThostFtdcSecAgentACIDMapField;
import ctp.thostapi.CThostFtdcSecAgentCheckModeField;
import ctp.thostapi.CThostFtdcSettlementInfoConfirmField;
import ctp.thostapi.CThostFtdcSettlementInfoField;
import ctp.thostapi.CThostFtdcTradeField;
import ctp.thostapi.CThostFtdcTraderSpi;
import ctp.thostapi.CThostFtdcTradingAccountField;
import ctp.thostapi.CThostFtdcTradingAccountPasswordUpdateField;
import ctp.thostapi.CThostFtdcTradingCodeField;
import ctp.thostapi.CThostFtdcTradingNoticeField;
import ctp.thostapi.CThostFtdcTradingNoticeInfoField;
import ctp.thostapi.CThostFtdcTransferBankField;
import ctp.thostapi.CThostFtdcTransferSerialField;
import ctp.thostapi.CThostFtdcUserLogoutField;
import ctp.thostapi.CThostFtdcUserPasswordUpdateField;

public class TdSpi extends CThostFtdcTraderSpi {

	private Logger log = LoggerFactory.getLogger(TdSpi.class);

	private CtpGateway gateway;
	private String gatewayId;

	// private HashMap<String, String> originalOrderIdMap = new HashMap<>();

	TdSpi(CtpGateway gateway) {
		this.gateway = gateway;
		this.gatewayId = gateway.getGatewayId();
	}

	// 登录起始阶段缓存Order
	// private List<Order> orderCacheList = new LinkedList<>();
	// 登录起始阶段缓存Trade
	// private List<Trade> tradeCacheList = new LinkedList<>();

	// 前置机联机回报
	public void OnFrontConnected() {
		log.info("{}-TdApi front connected.", gatewayId);
		gateway.onFrontConnectedOfTdSpi();
	}

	// 前置机断开回报
	public void OnFrontDisconnected(int nReason) {
		log.info("{}-TdApi front disconnected, Reason : {}", gatewayId, nReason);
		gateway.onFrontDisconnectedOfTdSpi(nReason);
	}

	// 登录回报
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0) {
			log.info("{} TdApi login success. tradingDay==[{}], sessionId==[{}], brokerId==[{}], userId==[{}]",
					gatewayId, pRspUserLogin.getTradingDay(), pRspUserLogin.getSessionID(), pRspUserLogin.getBrokerID(),
					pRspUserLogin.getUserID());
			gateway.setTdFrontId(pRspUserLogin.getFrontID());
			gateway.setTdSessionId(pRspUserLogin.getSessionID());
			gateway.onRspUserLoginOfTdSpi(true);
//			// 确认结算单
//			CThostFtdcSettlementInfoConfirmField settlementInfoConfirmField = new CThostFtdcSettlementInfoConfirmField();
//			settlementInfoConfirmField.setBrokerID(brokerId);
//			settlementInfoConfirmField.setInvestorID(userId);
//			cThostFtdcTraderApi.ReqSettlementInfoConfirm(settlementInfoConfirmField, reqID.incrementAndGet());
		} else {
			log.error("{} TdApi login failure, errorId==[{}], errorMsg==[{}]", gatewayId, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			gateway.onRspUserLoginOfTdSpi(false);
		}

	}

	// 心跳警告
	public void OnHeartBeatWarning(int nTimeLapse) {
		log.warn("{} OnHeartBeatWarning, nTimeLapse==[{}]", gatewayId, nTimeLapse);
	}

	// 登出回报
	public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		if (pRspInfo.getErrorID() != 0)
			log.info("{}OnRspUserLogout!ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
		else
			log.info("{}OnRspUserLogout!BrokerID:{},UserID:{}", gatewayId, pUserLogout.getBrokerID(),
					pUserLogout.getUserID());
	}

	// 错误回报
	public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		log.error("{}交易接口错误回报!ErrorID:{},ErrorMsg:{},RequestID:{},isLast:{}", gatewayId, pRspInfo.getErrorID(),
				pRspInfo.getErrorMsg(), nRequestID, bIsLast);

	}

	// 验证客户端回报
	public void OnRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0) {
			log.info(gatewayId + "交易接口客户端验证成功");
			gateway.onRspAuthenticate();
		} else
			log.error("{}交易接口客户端验证失败! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
	}

	public void OnRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspTradingAccountPasswordUpdate(
			CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	// 发单错误(柜台)
	public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {

		// TODO

		// 发送委托事件
		log.error("{}交易接口发单错误回报(柜台)! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

	}

	public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	// 撤单错误回报(柜台)
	public void OnRspOrderAction(CThostFtdcInputOrderActionField pInputOrderAction, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		log.error("{}交易接口撤单错误（柜台）! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(), pRspInfo.getErrorMsg());
	}

	public void OnRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	// 确认结算信息回报
	public void OnRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0)
			log.warn("{}交易接口结算信息确认完成!", gatewayId);
		else
			log.error("{}交易接口结算信息确认出错! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
		// 查询所有合约
		log.warn("{}交易接口开始查询合约信息!", gatewayId);
//		CThostFtdcQryInstrumentField cThostFtdcQryInstrumentField = new CThostFtdcQryInstrumentField();
//		cThostFtdcTraderApi.ReqQryInstrument(cThostFtdcQryInstrumentField, reqId.incrementAndGet());

	}

	public void OnRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField pRemoveParkedOrder,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspExecOrderAction(CThostFtdcInputExecOrderActionField pInputExecOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQuoteAction(CThostFtdcInputQuoteActionField pInputQuoteAction, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspBatchOrderAction(CThostFtdcInputBatchOrderActionField pInputBatchOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField pInputOptionSelfClose,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspOptionSelfCloseAction(CThostFtdcInputOptionSelfCloseActionField pInputOptionSelfCloseAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspCombActionInsert(CThostFtdcInputCombActionField pInputCombAction, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryOrder(CThostFtdcOrderField pOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryTrade(CThostFtdcTradeField pTrade, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	// 持仓查询回报
	// TODO Recode
	public void OnRspQryInvestorPosition(CThostFtdcInvestorPositionField pInvestorPosition,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

		// TODO

	}

	// 账户查询回报
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		// TODO

	}

	public void OnRspQryInvestor(CThostFtdcInvestorField pInvestor, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryExchange(CThostFtdcExchangeField pExchange, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryProduct(CThostFtdcProductField pProduct, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	// 合约查询回报
	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		// TODO

	}

	public void OnRspQryDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryTransferBank(CThostFtdcTransferBankField pTransferBank, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField pInvestorPositionDetail,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryNotice(CThostFtdcNoticeField pNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInvestorPositionCombineDetail(
			CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField pEWarrantOffset, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInvestorProductGroupMargin(
			CThostFtdcInvestorProductGroupMarginField pInvestorProductGroupMargin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryExchangeMarginRate(CThostFtdcExchangeMarginRateField pExchangeMarginRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryExchangeMarginRateAdjust(CThostFtdcExchangeMarginRateAdjustField pExchangeMarginRateAdjust,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryExchangeRate(CThostFtdcExchangeRateField pExchangeRate, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQrySecAgentACIDMap(CThostFtdcSecAgentACIDMapField pSecAgentACIDMap,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryProductExchRate(CThostFtdcProductExchRateField pProductExchRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryProductGroup(CThostFtdcProductGroupField pProductGroup, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryMMInstrumentCommissionRate(
			CThostFtdcMMInstrumentCommissionRateField pMMInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryMMOptionInstrCommRate(CThostFtdcMMOptionInstrCommRateField pMMOptionInstrCommRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInstrumentOrderCommRate(CThostFtdcInstrumentOrderCommRateField pInstrumentOrderCommRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQrySecAgentTradingAccount(CThostFtdcTradingAccountField pTradingAccount,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQrySecAgentCheckMode(CThostFtdcSecAgentCheckModeField pSecAgentCheckMode,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryOptionInstrTradeCost(CThostFtdcOptionInstrTradeCostField pOptionInstrTradeCost,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryOptionInstrCommRate(CThostFtdcOptionInstrCommRateField pOptionInstrCommRate,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryExecOrder(CThostFtdcExecOrderField pExecOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryForQuote(CThostFtdcForQuoteField pForQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryQuote(CThostFtdcQuoteField pQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	}

	public void OnRspQryOptionSelfClose(CThostFtdcOptionSelfCloseField pOptionSelfClose,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryInvestUnit(CThostFtdcInvestUnitField pInvestUnit, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryCombInstrumentGuard(CThostFtdcCombInstrumentGuardField pCombInstrumentGuard,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryCombAction(CThostFtdcCombActionField pCombAction, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryTransferSerial(CThostFtdcTransferSerialField pTransferSerial, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryAccountregister(CThostFtdcAccountregisterField pAccountregister,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	// 委托回报
	public void OnRtnOrder(CThostFtdcOrderField pOrder) {

		// TODO

	}

	// 成交回报
	public void OnRtnTrade(CThostFtdcTradeField pTrade) {

		// TODO
	}

	// 发单错误回报(交易所)
	public void OnErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo) {

		// TODO

		log.error("{}交易接口发单错误回报（交易所）! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
				pRspInfo.getErrorMsg());

	}

	// 撤单错误回报(交易所)
	public void OnErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
		log.error("{}交易接口撤单错误回报（交易所）! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
				pRspInfo.getErrorMsg());
	}

	public void OnRtnInstrumentStatus(CThostFtdcInstrumentStatusField pInstrumentStatus) {
	}

	public void OnRtnBulletin(CThostFtdcBulletinField pBulletin) {
	}

	public void OnRtnTradingNotice(CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {
	}

	public void OnRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {
	}

	public void OnRtnExecOrder(CThostFtdcExecOrderField pExecOrder) {
	}

	public void OnErrRtnExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnExecOrderAction(CThostFtdcExecOrderActionField pExecOrderAction,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRtnQuote(CThostFtdcQuoteField pQuote) {
	}

	public void OnErrRtnQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnQuoteAction(CThostFtdcQuoteActionField pQuoteAction, CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {
	}

	public void OnRtnCFMMCTradingAccountToken(CThostFtdcCFMMCTradingAccountTokenField pCFMMCTradingAccountToken) {
	}

	public void OnErrRtnBatchOrderAction(CThostFtdcBatchOrderActionField pBatchOrderAction,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRtnOptionSelfClose(CThostFtdcOptionSelfCloseField pOptionSelfClose) {
	}

	public void OnErrRtnOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField pInputOptionSelfClose,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnOptionSelfCloseAction(CThostFtdcOptionSelfCloseActionField pOptionSelfCloseAction,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRtnCombAction(CThostFtdcCombActionField pCombAction) {
	}

	public void OnErrRtnCombActionInsert(CThostFtdcInputCombActionField pInputCombAction,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRspQryContractBank(CThostFtdcContractBankField pContractBank, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryTradingNotice(CThostFtdcTradingNoticeField pTradingNotice, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField pBrokerTradingParams,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRspQueryCFMMCTradingAccountToken(
			CThostFtdcQueryCFMMCTradingAccountTokenField pQueryCFMMCTradingAccountToken,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRtnFromBankToFutureByBank(CThostFtdcRspTransferField pRspTransfer) {
	}

	public void OnRtnFromFutureToBankByBank(CThostFtdcRspTransferField pRspTransfer) {
	}

	public void OnRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRtnFromBankToFutureByFuture(CThostFtdcRspTransferField pRspTransfer) {
	}

	public void OnRtnFromFutureToBankByFuture(CThostFtdcRspTransferField pRspTransfer) {
	}

	public void OnRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {
	}

	public void OnErrRtnBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField pReqRepeal,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField pReqRepeal,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount,
			CThostFtdcRspInfoField pRspInfo) {
	}

	public void OnRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField pRspRepeal) {
	}

	public void OnRspFromBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspFromFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
	}

	public void OnRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {
	}

	public void OnRtnCancelAccountByBank(CThostFtdcCancelAccountField pCancelAccount) {
	}

	public void OnRtnChangeAccountByBank(CThostFtdcChangeAccountField pChangeAccount) {
	}
}