package io.ffreedom.jctp;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.THOST_TE_RESUME_TYPE;
import io.ffreedom.common.utils.ThreadUtil;

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

	public static void main(String[] args) {
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi("trader");
		TraderSpiImpl traderSpiImpl = new TraderSpiImpl(traderApi);
		traderApi.RegisterSpi(traderSpiImpl);
		traderApi.RegisterFront(CtpInfo.TradeAddress);
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.Init();
		// 这里sleep是为了保证traderapi的登录查询成功
		ThreadUtil.sleep(5000);
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi("md");
		Set<String> instruementIdSet = new HashSet<>();
		instruementIdSet.add("rb1905");
		instruementIdSet.add("ni1905");
		instruementIdSet.add("CF905");
		MdSpiImpl mdSpiImpl = new MdSpiImpl(mdApi, instruementIdSet);
		mdApi.RegisterSpi(mdSpiImpl);
		mdApi.RegisterFront(CtpInfo.MdAddress);
		mdApi.Init();

		traderApi.Join();
		mdApi.Join();
	}
}