package io.ffreedom.jctp.gateway;

import java.io.File;
import java.util.HashMap;
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
 * @author sun0x00@gmail.com
 */
public class CtpGateway {

	private static Logger log = LoggerFactory.getLogger(CtpGateway.class);

	private Timer timer = new Timer();

	static {
		try {
			if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
				System.load("libs" + File.separator + "libiconv.dll");
				System.load("libs" + File.separator + "thostmduserapi.dll");
				System.load("libs" + File.separator + "jctpmdapiv6v3v11x64.dll");
				System.load("libs" + File.separator + "thosttraderapi.dll");
				System.load("libs" + File.separator + "jctptraderapiv6v3v11x64.dll");
			} else {
				System.load("libs" + File.separator + "libthostmduserapi.so");
				System.load("libs" + File.separator + "libjctpmdapiv6v3v11x64.so");
				System.load("libs" + File.separator + "libthosttraderapi.so");
				System.load("libs" + File.separator + "libjctptraderapiv6v3v11x64.so");
			}
		} catch (Exception e) {
			log.error("加载库失败!", e);
		}

	}

	private HashSet<String> subscribedSymbols = new HashSet<>();
	private HashMap<String, String> contractExchangeMap = new HashMap<>();
	private HashMap<String, Integer> contractSizeMap = new HashMap<>();
	private HashMap<String, String> contractNameMap = new HashMap<>();

	private MdSpi mdSpi = new MdSpi(this, new MdSpiConfig());
	private TdSpi tdSpi = new TdSpi(this, new TdSpiConfig());

	public CtpGateway() {
		timer.schedule(new TimerTask() {
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

	public HashMap<String, String> getContractExchangeMap() {
		return contractExchangeMap;
	}

	public HashMap<String, Integer> getContractSizeMap() {
		return contractSizeMap;
	}

	public HashMap<String, String> getContractNameMap() {
		return contractNameMap;
	}

	public HashSet<String> getSubscribedSymbols() {
		return subscribedSymbols;
	}

	public void subscribe(String symbol) {
		subscribedSymbols.add(symbol);
		if (mdSpi != null)
			mdSpi.subscribe(symbol);

	}

	public void unSubscribe(String rtSymbol) {
		String[] rtSymbolArray = rtSymbol.split("\\.");
		String symbol = rtSymbol;
		if (rtSymbolArray.length > 1)
			symbol = rtSymbol.replace(("." + rtSymbolArray[rtSymbolArray.length - 1]), "");

		subscribedSymbols.remove(symbol);
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

}
