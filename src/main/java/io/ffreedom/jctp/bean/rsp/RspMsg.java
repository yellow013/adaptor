package io.ffreedom.jctp.bean.rsp;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcTradeField;

public final class RspMsg {

	private RspMsgType type;
	private CThostFtdcDepthMarketDataField depthMarketData;
	private CThostFtdcOrderField rtnOrder;
	private CThostFtdcTradeField rtnTrade;

	private RspMsg(RspMsgType type) {
		this.type = type;
	}

	private RspMsg setDepthMarketData(CThostFtdcDepthMarketDataField depthMarketData) {
		this.depthMarketData = depthMarketData;
		return this;
	}

	private RspMsg setRtnOrder(CThostFtdcOrderField rtnOrder) {
		this.rtnOrder = rtnOrder;
		return this;
	}

	private RspMsg setRtnTrade(CThostFtdcTradeField rtnTrade) {
		this.rtnTrade = rtnTrade;
		return this;
	}

	public static final RspMsg ofDepthMarketData(CThostFtdcDepthMarketDataField depthMarketData) {
		return new RspMsg(RspMsgType.DepthMarketData).setDepthMarketData(depthMarketData);
	}

	public static final RspMsg ofRtnOrder(CThostFtdcOrderField order) {
		return new RspMsg(RspMsgType.RtnOrder).setRtnOrder(order);
	}

	public static final RspMsg ofRtnTrade(CThostFtdcTradeField trade) {
		return new RspMsg(RspMsgType.RtnTrade).setRtnTrade(trade);
	}

	public RspMsgType getType() {
		return type;
	}

	public CThostFtdcDepthMarketDataField getDepthMarketData() {
		return depthMarketData;
	}

	public CThostFtdcOrderField getRtnOrder() {
		return rtnOrder;
	}

	public CThostFtdcTradeField getRtnTrade() {
		return rtnTrade;
	}

}
