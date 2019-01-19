package io.ffreedom.jctp.gateway;

import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.ffreedom.jctp.gateway.config.MdSpiConfig;
import io.ffreedom.jctp.gateway.config.TdSpiConfig;
import io.ffreedom.jctp.gateway.dto.ReqCancelOrder;
import io.ffreedom.jctp.gateway.dto.ReqOrder;

/**
 */
public class CtpGateway {

	private static Logger log = LoggerFactory.getLogger(CtpGateway.class);

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

	private MdSpi mdSpi;
	private TdSpi tdSpi;

	public CtpGateway(MdSpiConfig mdSpiConfig, TdSpiConfig tdSpiConfig) {
		if (mdSpiConfig != null)
			this.mdSpi = new MdSpi(this, mdSpiConfig);
		if (tdSpiConfig != null)
			this.tdSpi = new TdSpi(this, tdSpiConfig);
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

	public HashSet<String> getSubscribedSymbols() {
		return subscribeSymbols;
	}

	public void subscribe(String symbol) {
		subscribeSymbols.add(symbol);
		if (mdSpi != null)
			mdSpi.subscribe(symbol);

	}

	public void unsubscribe(String symbol) {
		subscribeSymbols.remove(symbol);
		if (mdSpi != null)
			mdSpi.unSubscribe(symbol);
	}

	public void connect() {
		if (tdSpi != null)
			tdSpi.connect();
		if (mdSpi != null)
			mdSpi.connect();
	}

	public void close() {
		// 务必判断连接状态,防止死循环
		if (tdSpi != null && tdSpi.isConnected())
			tdSpi.close();
		if (mdSpi != null && mdSpi.isConnected())
			mdSpi.close();
		// 在这里发送事件主要是由于接口可能自动断开,需要广播通知
	}

	public String sendOrder(ReqOrder reqOrder) {
		if (tdSpi != null)
			return tdSpi.sendOrder(reqOrder);
		else
			return null;
	}

	public void cancelOrder(ReqCancelOrder reqCancelOrder) {
		if (tdSpi != null)
			tdSpi.cancelOrder(reqCancelOrder);
	}

	public void queryAccount() {
		if (tdSpi != null)
			tdSpi.queryAccount();

	}

	public void queryPosition() {
		if (tdSpi != null)
			tdSpi.queryPosition();
	}

	public boolean isConnected() {
		return tdSpi != null && mdSpi != null && tdSpi.isConnected() && mdSpi.isConnected();
	}

	public static void main(String[] args) {

//		CtpGateway ctpGateway = new CtpGateway(new MdSpiConfig().setMdAddress("180.168.146.187:10010")
//				.setBrokerId("9999").setUserId("005853").setPassword("jinpengpass101")
//
//				.setGatewayId("Simnow").setGatewayName("Simnow"), null);
//
//		ctpGateway.subscribe("rb1905");

	}

}
