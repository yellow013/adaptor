package ctp.thostapi.demo;

import java.util.Iterator;
import java.util.Vector;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcInstrumentField;
import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcMdSpi;
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
import ctp.thostapi.THOST_TE_RESUME_TYPE;

interface CtpInfo {

	String TradeAddress = "tcp://180.168.146.187:10000";
	String MdAddress = "tcp://180.168.146.187:10010";

	String BrokerId = "9999";
	String InvestorId = "005853";
	String UserId = "005853";
	String AccountId = "005853";
	String Password = "jinpengpass101";

	String TradingDay = "20190201";
	String CurrencyId = "CNY";

}

class TraderSpiImpl extends CThostFtdcTraderSpi {

	private CThostFtdcTraderApi m_traderapi;
	private Vector<String> m_instr_vec;

	TraderSpiImpl(CThostFtdcTraderApi traderapi, Vector<String> instrs) {
		m_traderapi = traderapi;
		m_instr_vec = instrs;
	}

	@Override
	public void OnFrontConnected() {
		System.out.println("On Front Connected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(CtpInfo.BrokerId);
		field.setUserID(CtpInfo.UserId);
		field.setPassword(CtpInfo.Password);
		field.setUserProductInfo("JAVA_API");
		m_traderapi.ReqUserLogin(field, 0);
		System.out.println("Send login ok");
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			System.out.printf("Login ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());
			return;
		}
		System.out.println("Login success!!!");
		CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
		qryTradingAccount.setBrokerID(CtpInfo.BrokerId);
		qryTradingAccount.setCurrencyID(CtpInfo.CurrencyId);
		qryTradingAccount.setInvestorID(CtpInfo.InvestorId);
		// m_traderapi.ReqQryTradingAccount(qryTradingAccount, 1);

		CThostFtdcQrySettlementInfoField qrysettlement = new CThostFtdcQrySettlementInfoField();
		qrysettlement.setBrokerID(CtpInfo.BrokerId);
		qrysettlement.setInvestorID(CtpInfo.InvestorId);
		qrysettlement.setTradingDay(CtpInfo.TradingDay);
		qrysettlement.setAccountID(CtpInfo.AccountId);
		qrysettlement.setCurrencyID(CtpInfo.CurrencyId);
		// m_traderapi.ReqQrySettlementInfo(qrysettlement, 2);

		CThostFtdcQryInstrumentField qryInstr = new CThostFtdcQryInstrumentField();
		m_traderapi.ReqQryInstrument(qryInstr, 3);
		System.out.println("Query success!!!");
	}

	@Override
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			System.out.printf("OnRspQryTradingAccount ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			return;
		}
		if (pTradingAccount != null) {
			System.out.printf("Balance[%f]Available[%f]WithdrawQuota[%f]Credit[%f]\n", pTradingAccount.getBalance(),
					pTradingAccount.getAvailable(), pTradingAccount.getWithdrawQuota(), pTradingAccount.getCredit());
		} else {
			System.out.printf("NULL obj");
		}
	}

	public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			System.out.printf("OnRspQrySettlementInfo ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(),
					pRspInfo.getErrorMsg());
			return;
		}
		if (pSettlementInfo != null) {
			System.out.println("OnRspQrySettlementInfo -> \n" + pSettlementInfo.getContent());
		} else {
			System.out.println("NULL obj");
		}
	}

	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspInfo != null && pRspInfo.getErrorID() != 0) {
			System.out.printf(
					"OnRspQryInstrument ErrorID[" + pRspInfo.getErrorID() + "] ErrMsg[" + pRspInfo.getErrorMsg() + "]");
			return;
		}
		if (pInstrument != null) {
			System.out.println("OnRspQryInstrument -> " + pInstrument.getInstrumentID());
			m_instr_vec.add(pInstrument.getInstrumentID());
		} else {
			System.out.println("NULL obj");
		}
	}

}

class MdSpiImpl extends CThostFtdcMdSpi {

	private CThostFtdcMdApi m_mdapi;
	private Vector<String> m_instr_vec;

	MdSpiImpl(CThostFtdcMdApi mdapi, Vector<String> instrs) {
		m_mdapi = mdapi;
		m_instr_vec = instrs;
	}

	public void OnFrontConnected() {
		System.out.println("On Front Connected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(CtpInfo.BrokerId);
		field.setUserID(CtpInfo.UserId);
		field.setPassword(CtpInfo.Password);
		m_mdapi.ReqUserLogin(field, 0);

	}

	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo,
			int nRequestID, boolean bIsLast) {
		if (pRspUserLogin != null) {
			System.out.println("Brokerid[" + pRspUserLogin.getBrokerID() + "]");
		}
		String[] instruementid = new String[1];
		Iterator<String> iterator = m_instr_vec.iterator();
		while (iterator.hasNext()) {
			instruementid[0] = iterator.next().toString();
			m_mdapi.SubscribeMarketData(instruementid, 1);
			System.out.println("SubscribeMarketData -> " + instruementid[0]);
		}
	}

	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null) {
			System.out.println("InstrumentID[" + pDepthMarketData.getInstrumentID() + "], UpdateTime["
					+ pDepthMarketData.getUpdateTime() + "], UpdateMillisec[" + pDepthMarketData.getUpdateMillisec()
					+ "], AskPrice1[" + pDepthMarketData.getAskPrice1() + "], BidPrice1["
					+ pDepthMarketData.getBidPrice1() + "]");
		} else {
			System.out.println("NULL obj");
		}
	}

}

public class Demo {

	static {
		System.loadLibrary("lib/win64/thosttraderapi");
		System.loadLibrary("lib/win64/thostmduserapi");
		System.loadLibrary("lib/win64/thostapi_wrap");
	}

	static Vector<String> instr_vec = new Vector<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(System.getProperty("java.library.path"));
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi("trade");
		TraderSpiImpl traderSpiImpl = new TraderSpiImpl(traderApi, instr_vec);
		traderApi.RegisterSpi(traderSpiImpl);
		traderApi.RegisterFront(CtpInfo.TradeAddress);
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.Init();
		// 这里sleep是为了保证traderapi的登录查询成功
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		instr_vec.clear();
		instr_vec.add("rb1905");
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi("md");
		MdSpiImpl mdSpiImpl = new MdSpiImpl(mdApi, instr_vec);
		mdApi.RegisterSpi(mdSpiImpl);
		mdApi.RegisterFront(CtpInfo.MdAddress);
		mdApi.Init();

		traderApi.Join();
		mdApi.Join();
		return;
	}
}