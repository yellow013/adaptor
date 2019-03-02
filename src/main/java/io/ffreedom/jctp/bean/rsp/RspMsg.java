package io.ffreedom.jctp.bean.rsp;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcTradeField;

public final class RspMsg {

	private RspMsgType type;
	private Object msg;

	public static final RspMsg ofDepthMarketData(CThostFtdcDepthMarketDataField msg) {
		return new RspMsg(RspMsgType.DepthMarketData, msg);
	}

	public static final RspMsg ofOrder(CThostFtdcOrderField order) {
		return new RspMsg(RspMsgType.Order, order);
	}

	public static final RspMsg ofTrade(CThostFtdcTradeField trade) {
		return new RspMsg(RspMsgType.Trade, trade);
	}

	private RspMsg(RspMsgType type, Object msg) {
		this.type = type;
		this.msg = msg;
	}

	public RspMsgType getType() {
		return type;
	}

	public Object getMsg() {
		return msg;
	}

}
