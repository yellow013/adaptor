package io.ffreedom.jctp.gateway;

import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.ffreedom.jctp.gateway.config.MdApiConfig;
import io.ffreedom.jctp.gateway.config.TdApiConfig;
import io.ffreedom.jctp.gateway.dto.ReqCancelOrder;
import io.ffreedom.jctp.gateway.dto.ReqOrder;

/**
 */
/**
 * @author Administrator
 *
 */
public class CtpGateway {

	private static Logger log = LoggerFactory.getLogger(CtpGateway.class);

	static final int FromMd = 0;

	static final int FromTd = 1;

	static {
		try {
			// 判断是否是windows操作系统
			if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
				System.load(new File("libs" + File.separator + "libiconv.dll").getAbsolutePath());
				System.load(new File("libs" + File.separator + "thostmduserapi.dll").getAbsolutePath());
				System.load(new File("libs" + File.separator + "jctpmdapiv6v3v11x64.dll").getAbsolutePath());
				System.load(new File("libs" + File.separator + "thosttraderapi.dll").getAbsolutePath());
				System.load(new File("libs" + File.separator + "jctptraderapiv6v3v11x64.dll").getAbsolutePath());
			} else {
				System.load(new File("libs" + File.separator + "libthostmduserapi.so").getAbsolutePath());
				System.load(new File("libs" + File.separator + "libjctpmdapiv6v3v11x64.so").getAbsolutePath());
				System.load(new File("libs" + File.separator + "libthosttraderapi.so").getAbsolutePath());
				System.load(new File("libs" + File.separator + "libjctptraderapiv6v3v11x64.so").getAbsolutePath());
			}
		} catch (Exception e) {
			log.error("Load libs error...", e);
		}
	}

	private HashSet<String> subscribeSymbols = new HashSet<>();

	private MdApi mdApi;
	private TdApi tdApi;

	private MdSpi mdSpi;
	private TdSpi tdSpi;

	private String gatewayId;

	public CtpGateway(String gatewayId, MdApiConfig mdApiConfig, TdApiConfig tdApiConfig) {
		this.gatewayId = gatewayId;
		this.mdSpi = new MdSpi(this);
		this.tdSpi = new TdSpi(this);
		if (mdApiConfig != null)
			this.mdApi = new MdApi(gatewayId, mdSpi, mdApiConfig);
		if (tdApiConfig != null)
			this.tdApi = new TdApi(gatewayId, tdSpi, tdApiConfig);
		if (mdApi == null || tdApi == null)
			throw new RuntimeException("Cannot init...");
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					if (isConnected())
						queryAccount();
					Thread.sleep(1250);
					if (isConnected())
						queryPosition();
					Thread.sleep(1250);
				} catch (Exception e) {
					log.error(getClass().getSimpleName() + "定时查询发生异常", e);
				}
			}
		}, 0, 3000);
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public HashSet<String> getSubscribedSymbols() {
		return subscribeSymbols;
	}

	public void subscribe(String symbol) {
		subscribeSymbols.add(symbol);
		if (mdApi != null)
			mdApi.subscribe(symbol);

	}

	public void unsubscribe(String symbol) {
		subscribeSymbols.remove(symbol);
		if (mdApi != null)
			mdApi.unsubscribe(symbol);
	}

	public void connect() {
		if (mdApi != null)
			mdApi.connect();
		if (tdApi != null)
			tdApi.connect();
	}

	public void close() {
		// 务必判断连接状态,防止死循环
		if (mdApi != null && mdApi.isConnected())
			mdApi.close();
		if (tdApi != null && tdSpi.isConnected())
			tdApi.close();
		// 在这里发送事件主要是由于接口可能自动断开,需要广播通知
	}

	public void sendOrder(ReqOrder reqOrder) {
		if (tdApi != null)
			tdApi.sendOrder(reqOrder);
	}

	public void cancelOrder(ReqCancelOrder reqCancelOrder) {
		if (tdApi != null)
			tdApi.cancelOrder(reqCancelOrder);
	}

	public void queryAccount() {
		if (tdApi != null)
			tdApi.queryAccount();
	}

	public void queryPosition() {
		if (tdApi != null)
			tdApi.queryPosition();
	}

	public boolean isConnected() {
		return tdApi.isConnected() && mdApi.isConnected();
	}

	public void onFrontConnected(int from) {
		switch (from) {
		case FromMd:
			mdApi.setConnected(true);
			mdApi.login();
			return;
		case FromTd:
			tdApi.setConnected(true);
			tdApi.login();
			return;
		default:
			return;
		}
	}

	public void onFrontDisconnected(int nReason, int from) {
		switch (from) {
		case FromMd:
			if (mdApi != null)
				mdApi.close();
			return;
		case FromTd:
			if (tdApi != null)
				tdApi.close();
			return;
		default:
			return;
		}

	}

	public static void main(String[] args) {

//		CtpGateway ctpGateway = new CtpGateway(new MdSpiConfig().setMdAddress("180.168.146.187:10010")
//				.setBrokerId("9999").setUserId("005853").setPassword("jinpengpass101")
//
//				.setGatewayId("Simnow").setGatewayName("Simnow"), null);
//
//		ctpGateway.subscribe("rb1905");

	}

	public void onRspUserLogin(int from) {
		switch (from) {
		case FromMd:
			mdApi.setLogin(true);
			if (!subscribeSymbols.isEmpty())
				mdApi.subscribe(subscribeSymbols.toArray(new String[subscribeSymbols.size()]));
			return;
		case FromTd:
			
			return;
		default:
			return;
		}
		
	}

	public void onRspUserLogout() {
		// TODO Auto-generated method stub

	}

	public void onRspError() {
		// TODO Auto-generated method stub

	}

	public void onRspSubMarketData() {
		// TODO Auto-generated method stub

	}

	public void onRspUnSubMarketData() {
		// TODO Auto-generated method stub

	}

	public void onRtnDepthMarketData() {
		// TODO Auto-generated method stub

	}

}
