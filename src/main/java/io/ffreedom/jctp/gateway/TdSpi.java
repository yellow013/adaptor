package io.ffreedom.jctp.gateway;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.util.FileUtil;
import io.ffreedom.jctp.gateway.dto.ReqCancelOrder;
import io.ffreedom.jctp.gateway.dto.ReqOrder;
import io.ffreedom.jctp.jni.td.CThostFtdcAccountregisterField;
import io.ffreedom.jctp.jni.td.CThostFtdcBatchOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcBrokerTradingAlgosField;
import io.ffreedom.jctp.jni.td.CThostFtdcBrokerTradingParamsField;
import io.ffreedom.jctp.jni.td.CThostFtdcBulletinField;
import io.ffreedom.jctp.jni.td.CThostFtdcCFMMCTradingAccountKeyField;
import io.ffreedom.jctp.jni.td.CThostFtdcCFMMCTradingAccountTokenField;
import io.ffreedom.jctp.jni.td.CThostFtdcCancelAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcChangeAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcCombActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcCombInstrumentGuardField;
import io.ffreedom.jctp.jni.td.CThostFtdcContractBankField;
import io.ffreedom.jctp.jni.td.CThostFtdcDepthMarketDataField;
import io.ffreedom.jctp.jni.td.CThostFtdcEWarrantOffsetField;
import io.ffreedom.jctp.jni.td.CThostFtdcErrorConditionalOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcExchangeField;
import io.ffreedom.jctp.jni.td.CThostFtdcExchangeMarginRateAdjustField;
import io.ffreedom.jctp.jni.td.CThostFtdcExchangeMarginRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcExchangeRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcExecOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcExecOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcForQuoteField;
import io.ffreedom.jctp.jni.td.CThostFtdcForQuoteRspField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputBatchOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputCombActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputExecOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputExecOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputForQuoteField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputOptionSelfCloseActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputOptionSelfCloseField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputQuoteActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInputQuoteField;
import io.ffreedom.jctp.jni.td.CThostFtdcInstrumentCommissionRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcInstrumentField;
import io.ffreedom.jctp.jni.td.CThostFtdcInstrumentMarginRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcInstrumentOrderCommRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcInstrumentStatusField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestUnitField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestorField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestorPositionCombineDetailField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestorPositionDetailField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestorPositionField;
import io.ffreedom.jctp.jni.td.CThostFtdcInvestorProductGroupMarginField;
import io.ffreedom.jctp.jni.td.CThostFtdcMMInstrumentCommissionRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcMMOptionInstrCommRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcNoticeField;
import io.ffreedom.jctp.jni.td.CThostFtdcNotifyQueryAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcOpenAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcOptionInstrCommRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcOptionInstrTradeCostField;
import io.ffreedom.jctp.jni.td.CThostFtdcOptionSelfCloseActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcOptionSelfCloseField;
import io.ffreedom.jctp.jni.td.CThostFtdcOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcParkedOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcParkedOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcProductExchRateField;
import io.ffreedom.jctp.jni.td.CThostFtdcProductField;
import io.ffreedom.jctp.jni.td.CThostFtdcProductGroupField;
import io.ffreedom.jctp.jni.td.CThostFtdcQryInstrumentField;
import io.ffreedom.jctp.jni.td.CThostFtdcQryInvestorPositionField;
import io.ffreedom.jctp.jni.td.CThostFtdcQryTradingAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcQueryCFMMCTradingAccountTokenField;
import io.ffreedom.jctp.jni.td.CThostFtdcQueryMaxOrderVolumeField;
import io.ffreedom.jctp.jni.td.CThostFtdcQuoteActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcQuoteField;
import io.ffreedom.jctp.jni.td.CThostFtdcRemoveParkedOrderActionField;
import io.ffreedom.jctp.jni.td.CThostFtdcRemoveParkedOrderField;
import io.ffreedom.jctp.jni.td.CThostFtdcReqAuthenticateField;
import io.ffreedom.jctp.jni.td.CThostFtdcReqQueryAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcReqRepealField;
import io.ffreedom.jctp.jni.td.CThostFtdcReqTransferField;
import io.ffreedom.jctp.jni.td.CThostFtdcReqUserLoginField;
import io.ffreedom.jctp.jni.td.CThostFtdcRspAuthenticateField;
import io.ffreedom.jctp.jni.td.CThostFtdcRspInfoField;
import io.ffreedom.jctp.jni.td.CThostFtdcRspRepealField;
import io.ffreedom.jctp.jni.td.CThostFtdcRspTransferField;
import io.ffreedom.jctp.jni.td.CThostFtdcRspUserLoginField;
import io.ffreedom.jctp.jni.td.CThostFtdcSecAgentACIDMapField;
import io.ffreedom.jctp.jni.td.CThostFtdcSecAgentCheckModeField;
import io.ffreedom.jctp.jni.td.CThostFtdcSettlementInfoConfirmField;
import io.ffreedom.jctp.jni.td.CThostFtdcSettlementInfoField;
import io.ffreedom.jctp.jni.td.CThostFtdcTradeField;
import io.ffreedom.jctp.jni.td.CThostFtdcTraderApi;
import io.ffreedom.jctp.jni.td.CThostFtdcTraderSpi;
import io.ffreedom.jctp.jni.td.CThostFtdcTradingAccountField;
import io.ffreedom.jctp.jni.td.CThostFtdcTradingAccountPasswordUpdateField;
import io.ffreedom.jctp.jni.td.CThostFtdcTradingCodeField;
import io.ffreedom.jctp.jni.td.CThostFtdcTradingNoticeField;
import io.ffreedom.jctp.jni.td.CThostFtdcTradingNoticeInfoField;
import io.ffreedom.jctp.jni.td.CThostFtdcTransferBankField;
import io.ffreedom.jctp.jni.td.CThostFtdcTransferSerialField;
import io.ffreedom.jctp.jni.td.CThostFtdcUserLogoutField;
import io.ffreedom.jctp.jni.td.CThostFtdcUserPasswordUpdateField;
import io.ffreedom.jctp.jni.td.jctptraderapiv6v3v11x64Constants;

public class TdSpi extends CThostFtdcTraderSpi {

	private Logger log = LoggerFactory.getLogger(TdSpi.class);

	private CtpGateway ctpGateway;
	private String gatewayId;

	private HashMap<String, String> originalOrderIdMap = new HashMap<>();

	TdSpi(CtpGateway ctpGateway) {
		this.ctpGateway = ctpGateway;
		this.gatewayId = ctpGateway.getGatewayId();
	}

	

	private boolean connectProcessStatus = false; // 避免重复调用
	private boolean connectionStatus = false; // 前置机连接状态
	private boolean loginStatus = false; // 登陆状态
	private String tradingDayStr;

	private boolean instrumentQueried = false;

	private AtomicInteger reqID = new AtomicInteger(0); // 操作请求编号
	private AtomicInteger orderRef = new AtomicInteger(0); // 订单编号

	private boolean authStatus = false; // 验证状态
	private boolean loginFailed = false; // 是否已经使用错误的信息尝试登录过

	@SuppressWarnings("unused")
	private int frontID = 0; // 前置机编号
	@SuppressWarnings("unused")
	private int sessionID = 0; // 会话编号

	// 登录起始阶段缓存Order
	// private List<Order> orderCacheList = new LinkedList<>();
	// 登录起始阶段缓存Trade
	// private List<Trade> tradeCacheList = new LinkedList<>();

	

	/**
	 * 返回接口状态
	 * 
	 * @return
	 */
	public boolean isConnected() {
		return connectionStatus && loginStatus;
	}

	/**
	 * 获取交易日
	 * 
	 * @return
	 */
	public String getTradingDayStr() {
		return tradingDayStr;
	}

	

	// 前置机联机回报
	public void OnFrontConnected() {
		log.info("{} 交易接口前置机已连接", gatewayId);
		// 修改前置机连接状态为true
		connectionStatus = true;
		connectProcessStatus = false;
		login();
	}

	// 前置机断开回报
	public void OnFrontDisconnected(int nReason) {
		log.info("{} 交易接口前置机已断开, Reason:{}", gatewayId, nReason);
		close();
	}

	// 登录回报
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo.getErrorID() == 0) {
			log.info("{} 交易接口登录成功! TradingDay:{},SessionID:{},BrokerID:{},UserID:{}", gatewayName,
					pRspUserLogin.getTradingDay(), pRspUserLogin.getSessionID(), pRspUserLogin.getBrokerID(),
					pRspUserLogin.getUserID());
			sessionID = pRspUserLogin.getSessionID();
			frontID = pRspUserLogin.getFrontID();
			// 修改登录状态为true
			loginStatus = true;
			tradingDayStr = pRspUserLogin.getTradingDay();
			log.info("{}交易接口获取到的交易日为{}", gatewayId, tradingDayStr);

			// 确认结算单
			CThostFtdcSettlementInfoConfirmField settlementInfoConfirmField = new CThostFtdcSettlementInfoConfirmField();
			settlementInfoConfirmField.setBrokerID(brokerId);
			settlementInfoConfirmField.setInvestorID(userId);
			cThostFtdcTraderApi.ReqSettlementInfoConfirm(settlementInfoConfirmField, reqID.incrementAndGet());

		} else {
			log.error("{}交易接口登录回报错误! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			loginFailed = true;
		}

	}

	// 心跳警告
	public void OnHeartBeatWarning(int nTimeLapse) {
		log.warn("{} 交易接口心跳警告, Time Lapse:{}", gatewayId, nTimeLapse);
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
		loginStatus = false;
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
			authStatus = true;
			log.info(gatewayId + "交易接口客户端验证成功");
			login();
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
		log.error("{}交易接口发单错误回报(柜台)! ErrorID:{},ErrorMsg:{}", gatewayId, pRspInfo.getErrorID(),
				pRspInfo.getErrorMsg());

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
		CThostFtdcQryInstrumentField cThostFtdcQryInstrumentField = new CThostFtdcQryInstrumentField();
		cThostFtdcTraderApi.ReqQryInstrument(cThostFtdcQryInstrumentField, reqID.incrementAndGet());

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

	// 撤单错误回报（交易所）
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