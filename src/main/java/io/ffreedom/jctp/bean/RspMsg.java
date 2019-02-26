package io.ffreedom.jctp.bean;

import ctp.thostapi.CThostFtdcDepthMarketDataField;

public final class RspMsg {

	public static enum RspMsgType {
		MarketDate, Order
	}

	private RspMsgType type;
	private Object msg;

	public static final RspMsg newMarketDataRspMsg(CThostFtdcDepthMarketDataField msg) {
		return new RspMsg(RspMsgType.MarketDate, msg);
	}

	public static final RspMsg newOrderRspMsg() {
		return new RspMsg(RspMsgType.MarketDate, null);
	}

	public static final RspMsg newRspMsg(RspMsgType type, Object msg) {
		return new RspMsg(type, msg);
	}

	private RspMsg(RspMsgType type, Object msg) {
		this.type = type;
		this.msg = msg;
	}

	public RspMsgType getType() {
		return type;
	}

	public RspMsg setType(RspMsgType type) {
		this.type = type;
		return this;
	}

	public Object getMsg() {
		return msg;
	}

	public RspMsg setMsg(Object msg) {
		this.msg = msg;
		return this;
	}

}
