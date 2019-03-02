package io.ffreedom.jctp.bean.rsp;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcTradeField;

public final class RspMsg {

	private RspMsgType type;
	private CThostFtdcDepthMarketDataField depthMarketData;
	private CThostFtdcOrderField order;
	private CThostFtdcTradeField trade;

	public static final RspMsg ofDepthMarketData(CThostFtdcDepthMarketDataField msg) {
		return new RspMsg(RspMsgType.DepthMarketData);
	}

	public static final RspMsg ofOrder(CThostFtdcOrderField order) {
		return new RspMsg(RspMsgType.Order);
	}

	public static final RspMsg ofTrade(CThostFtdcTradeField trade) {
		return new RspMsg(RspMsgType.Trade);
	}

	private RspMsg(RspMsgType type) {
		this.type = type;
	}

	public RspMsgType getType() {
		return type;
	}

	public CThostFtdcDepthMarketDataField getDepthMarketData() {
		return depthMarketData;
	}

	public RspMsg setDepthMarketData(CThostFtdcDepthMarketDataField depthMarketData) {
		this.depthMarketData = depthMarketData;
		return this;
	}

	public CThostFtdcOrderField getOrder() {
		return order;
	}

	public RspMsg setOrder(CThostFtdcOrderField order) {
		this.order = order;
		return this;
	}

	public CThostFtdcTradeField getTrade() {
		return trade;
	}

	public RspMsg setTrade(CThostFtdcTradeField trade) {
		this.trade = trade;
		return this;
	}

}
