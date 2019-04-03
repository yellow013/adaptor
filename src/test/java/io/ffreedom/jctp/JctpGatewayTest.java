package io.ffreedom.jctp;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;

import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.common.queue.impl.ArrayBlockingMPSCQueue;
import io.ffreedom.common.utils.ThreadUtil;
import io.ffreedom.jctp.bean.config.JctpUserInfo;
import io.ffreedom.jctp.bean.rsp.RspDepthMarketData;
import io.ffreedom.jctp.bean.rsp.RtnOrder;
import io.ffreedom.jctp.bean.rsp.RtnTrade;

public class JctpGatewayTest {

	private final Logger logger = CommonLoggerFactory.getLogger(JctpGatewayTest.class);

	private String TradeAddress = "tcp://180.168.146.187:10000";
	private String MdAddress = "tcp://180.168.146.187:10010";

	private String BrokerId = "9999";
	private String InvestorId = "005853";
	private String UserId = "005853";
	private String AccountId = "005853";
	private String Password = "jinpengpass101";

	private String TradingDay = "20190201";
	private String CurrencyId = "CNY";

	private String GatewayId = "simnow_test";

	@Test
	public void test() {

		JctpUserInfo simnowUserInfo = JctpUserInfo.newEmpty().setTraderAddress(TradeAddress).setMdAddress(MdAddress)
				.setBrokerId(BrokerId).setInvestorId(InvestorId).setUserId(UserId).setAccountId(AccountId)
				.setPassword(Password).setTradingDay(TradingDay).setCurrencyId(CurrencyId);

		JctpGateway gateway = new JctpGateway(GatewayId, simnowUserInfo,
				ArrayBlockingMPSCQueue.autoRunQueue("Simnow-Handle-Queue", 1024, msg -> {
					switch (msg.getType()) {
					case DepthMarketData:
						RspDepthMarketData depthMarketData = msg.getRspDepthMarketData();
						logger.info(
								"Handle CThostFtdcDepthMarketDataField -> InstrumentID==[{}]  UpdateTime==[{}]  UpdateMillisec==[{}]  AskPrice1==[{}]  BidPrice1==[{}]",
								depthMarketData.getInstrumentID(), depthMarketData.getUpdateTime(),
								depthMarketData.getUpdateMillisec(), depthMarketData.getAskPrice1(),
								depthMarketData.getBidPrice1());
						break;
					case RtnOrder:
						RtnOrder order = msg.getRtnOrder();
						logger.info("Handle RtnOrder -> OrderRef==[{}]", order.getOrderRef());
						break;
					case RtnTrade:
						RtnTrade trade = msg.getRtnTrade();
						logger.info("Handle RtnTrade -> OrderRef==[{}]", trade.getOrderRef());
						break;
					default:
						break;
					}
				}));
		gateway.initAndJoin();
		Set<String> instruementIdSet = new HashSet<>();
		instruementIdSet.add("rb1905");
		gateway.subscribeMarketData(instruementIdSet);
		ThreadUtil.join();
	}

}
