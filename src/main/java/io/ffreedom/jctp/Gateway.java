package io.ffreedom.jctp;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.THOST_TE_RESUME_TYPE;
import io.ffreedom.common.queue.base.SCQueue;
import io.ffreedom.common.utils.ThreadUtil;
import io.ffreedom.jctp.bean.CtpUserInfo;
import io.ffreedom.jctp.bean.RspMsg;

public class Gateway {

	private static Logger logger = LoggerFactory.getLogger(Gateway.class);

	private static void loadWin64Library() {
		System.loadLibrary("lib/win64/thosttraderapi");
		System.loadLibrary("lib/win64/thostmduserapi");
		System.loadLibrary("lib/win64/thostapi_wrap");
	}

	private static void loadLinux64Library() {
		System.loadLibrary("lib/linux64/thosttraderapi");
		System.loadLibrary("lib/linux64/thostmduserapi");
		System.loadLibrary("lib/linux64/thostapi_wrap");
	}

	static {
		try {
			// 根据操作系统选择加载不同库文件
			if (System.getProperty("os.name").toLowerCase().startsWith("windows"))
				loadWin64Library();
			else
				loadLinux64Library();
			logger.info("Load libs success...");
		} catch (Throwable e) {
			logger.error("Load libs error...", e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public Gateway(String gatewayId, CtpUserInfo userInfo, SCQueue<RspMsg> outboundQueue) {
		String ctpTempFileHome = System.getProperty("user.home") + File.separator + "jctp";
		File ctpTempFilePath = new File(ctpTempFileHome + File.separator + "id_" + gatewayId);
		if (!ctpTempFilePath.exists())
			ctpTempFilePath.mkdirs();
		String traderTempFilePath = new File(ctpTempFilePath, "trader").getAbsolutePath();
		logger.info("{} trader use temp file path : {}", gatewayId, traderTempFilePath);
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi(traderTempFilePath);
		// TODO Add Queue
		TraderSpiImpl traderSpiImpl = new TraderSpiImpl(traderApi, userInfo, outboundQueue);
		traderApi.RegisterSpi(traderSpiImpl);
		traderApi.RegisterFront(userInfo.getTradeAddress());
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.Init();
		// Sleep是为了保证TraderApi的登录查询成功
		ThreadUtil.sleep(5000);
		String mdTempFilePath = new File(ctpTempFilePath, "md").getAbsolutePath();
		logger.info("{} md use temp file path : {}", gatewayId, mdTempFilePath);
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi(mdTempFilePath);
		Set<String> instruementIdSet = new HashSet<>();
		instruementIdSet.add("rb1910");
		// TODO Add Queue
		MdSpiImpl mdSpiImpl = new MdSpiImpl(mdApi, userInfo, instruementIdSet, outboundQueue);
		mdApi.RegisterSpi(mdSpiImpl);
		mdApi.RegisterFront(userInfo.getMdAddress());
		mdApi.Init();
		traderApi.Join();
		mdApi.Join();
	}

	private static String TradeAddress = "tcp://180.168.146.187:10000";
	private static String MdAddress = "tcp://180.168.146.187:10010";

	private static String BrokerId = "9999";
	private static String InvestorId = "005853";
	private static String UserId = "005853";
	private static String AccountId = "005853";
	private static String Password = "jinpengpass101";

	private static String TradingDay = "20190201";
	private static String CurrencyId = "CNY";

	private static String GatewayId = "simnow_test";

	private static CtpUserInfo SimnowUserInfo = CtpUserInfo.newEmpty().setTradeAddress(TradeAddress)
			.setMdAddress(MdAddress).setBrokerId(BrokerId).setInvestorId(InvestorId).setUserId(UserId)
			.setAccountId(AccountId).setPassword(Password).setTradingDay(TradingDay).setCurrencyId(CurrencyId);

	public static void main(String[] args) {
		new Gateway(GatewayId, SimnowUserInfo, null);
	}

}