package io.ffreedom.jctp;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.THOST_TE_RESUME_TYPE;
import io.ffreedom.common.datetime.DateTimeUtil;
import io.ffreedom.common.queue.api.Queue;
import io.ffreedom.common.utils.ThreadUtil;
import io.ffreedom.jctp.bean.CtpUserInfo;
import io.ffreedom.jctp.bean.RspMsg;

public class Gateway {

	private static final Logger logger = LoggerFactory.getLogger(Gateway.class);

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

	private String gatewayId;
	private CThostFtdcTraderApi traderApi;
	private CThostFtdcMdApi mdApi;

	public Gateway(String gatewayId, CtpUserInfo userInfo, Queue<RspMsg> outboundQueue) {
		this.gatewayId = gatewayId;
		File tempDir = getTempDir();

		String traderTempFilePath = new File(tempDir, "trader").getAbsolutePath();
		logger.info("{} trader use temp file path : {}", gatewayId, traderTempFilePath);
		this.traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi(traderTempFilePath);
		TraderSpiImpl traderSpiImpl = new TraderSpiImpl(traderApi, this, userInfo);
		traderApi.RegisterSpi(traderSpiImpl);
		traderApi.RegisterFront(userInfo.getTradeAddress());
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);

		String mdTempFilePath = new File(tempDir, "md").getAbsolutePath();
		logger.info("{} md use temp file path : {}", gatewayId, mdTempFilePath);
		this.mdApi = CThostFtdcMdApi.CreateFtdcMdApi(mdTempFilePath);
		MdSpiImpl mdSpiImpl = new MdSpiImpl(mdApi, this, userInfo);
		mdApi.RegisterSpi(mdSpiImpl);
		mdApi.RegisterFront(userInfo.getMdAddress());

		// traderApi.Join();
		// logger.info("Call traderApi.Join()...");
		// mdApi.Join();
		// logger.info("Call mdApi.Join()...");
	}

	private File getTempDir() {
		// 创建临时文件存储目录
		String tempFileHome = System.getProperty("user.home") + File.separator + "jctp";
		File tempFileDir = new File(
				tempFileHome + File.separator + DateTimeUtil.getCurrentDate() + File.separator + gatewayId);
		if (!tempFileDir.exists())
			tempFileDir.mkdirs();
		return tempFileDir;
	}

	public void initAndJoin() {
		traderApi.Init();
		logger.info("Call traderApi.Init()...");
		ThreadUtil.sleep(3000);
		mdApi.Init();
		logger.info("Call mdApi.Init()...");
		ThreadUtil.sleep(3000);
		ThreadUtil.join(Thread.currentThread());
	}

	public void subscribeMarketData(Set<String> instruementIdSet) {
		String[] instruementId = new String[1];
		Iterator<String> iterator = instruementIdSet.iterator();
		while (iterator.hasNext()) {
			instruementId[0] = iterator.next().toString();
			mdApi.SubscribeMarketData(instruementId, 1);
			logger.info("SubscribeMarketData -> " + instruementId[0]);
		}
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

	public static void main(String[] args) {
		CtpUserInfo simnowUserInfo = CtpUserInfo.newEmpty().setTradeAddress(TradeAddress).setMdAddress(MdAddress)
				.setBrokerId(BrokerId).setInvestorId(InvestorId).setUserId(UserId).setAccountId(AccountId)
				.setPassword(Password).setTradingDay(TradingDay).setCurrencyId(CurrencyId);
		Gateway gateway = new Gateway(GatewayId, simnowUserInfo, null);
		gateway.initAndJoin();

		ThreadUtil.sleep(5000);
		Set<String> instruementIdSet = new HashSet<>();
		instruementIdSet.add("rb1910");
		gateway.subscribeMarketData(instruementIdSet);
	}

}