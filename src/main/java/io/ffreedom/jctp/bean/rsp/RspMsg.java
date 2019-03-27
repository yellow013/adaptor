package io.ffreedom.jctp.bean.rsp;

import ctp.thostapi.CThostFtdcDepthMarketDataField;
import ctp.thostapi.CThostFtdcInputOrderActionField;
import ctp.thostapi.CThostFtdcInputOrderField;
import ctp.thostapi.CThostFtdcOrderActionField;
import ctp.thostapi.CThostFtdcOrderField;
import ctp.thostapi.CThostFtdcTradeField;

public final class RspMsg {

	private RspMsgType type;
	private RspCtpDepthMarketData ctpDepthMarketData;
	private CThostFtdcOrderField rtnOrder;
	private CThostFtdcTradeField rtnTrade;

	private CThostFtdcInputOrderField rspOrderInsert;
	private CThostFtdcInputOrderActionField rspOrderAction;

	private CThostFtdcInputOrderField errRtnOrderInsert;
	private CThostFtdcOrderActionField errRtnOrderAction;

	public static final RspMsg ofDepthMarketData(CThostFtdcDepthMarketDataField depthMarketData) {
		return new RspMsg(RspMsgType.DepthMarketData).setCtpDepthMarketData(new RspCtpDepthMarketData()
				.setTradingDay(depthMarketData.getTradingDay()).setInstrumentID(depthMarketData.getInstrumentID())
				.setExchangeID(depthMarketData.getExchangeID()).setLastPrice(depthMarketData.getLastPrice())
				.setPreSettlementPrice(depthMarketData.getPreSettlementPrice())
				.setPreClosePrice(depthMarketData.getPreClosePrice())
				.setPreOpenInterest(depthMarketData.getPreOpenInterest()).setOpenPrice(depthMarketData.getOpenPrice())
				.setHighestPrice(depthMarketData.getHighestPrice()).setLowestPrice(depthMarketData.getLowestPrice())
				.setVolume(depthMarketData.getVolume()).setTurnover(depthMarketData.getTurnover())
				.setOpenInterest(depthMarketData.getOpenInterest())
				.setUpperLimitPrice(depthMarketData.getUpperLimitPrice())
				.setLowerLimitPrice(depthMarketData.getLowerLimitPrice()).setBidPrice1(depthMarketData.getBidPrice1())
				.setBidVolume1(depthMarketData.getBidVolume1()).setAskPrice1(depthMarketData.getAskPrice1())
				.setAskVolume1(depthMarketData.getAskVolume1()).setBidPrice2(depthMarketData.getBidPrice2())
				.setBidVolume2(depthMarketData.getBidVolume2()).setAskPrice2(depthMarketData.getAskPrice2())
				.setAskVolume2(depthMarketData.getAskVolume2()).setBidPrice3(depthMarketData.getBidPrice3())
				.setBidVolume3(depthMarketData.getBidVolume3()).setAskPrice3(depthMarketData.getAskPrice3())
				.setAskVolume3(depthMarketData.getAskVolume3()).setBidPrice4(depthMarketData.getBidPrice4())
				.setBidVolume4(depthMarketData.getBidVolume4()).setAskPrice4(depthMarketData.getAskPrice4())
				.setAskVolume4(depthMarketData.getAskVolume4()).setBidPrice5(depthMarketData.getBidPrice5())
				.setBidVolume5(depthMarketData.getBidVolume5()).setAskPrice5(depthMarketData.getAskPrice5())
				.setAskVolume5(depthMarketData.getAskVolume5()).setAveragePrice(depthMarketData.getAveragePrice())
				.setUpdateTime(depthMarketData.getUpdateTime()).setUpdateMillisec(depthMarketData.getUpdateMillisec()));
	}

	public RspCtpDepthMarketData getCtpDepthMarketData() {
		return ctpDepthMarketData;
	}

	public RspMsg setCtpDepthMarketData(RspCtpDepthMarketData ctpDepthMarketData) {
		this.ctpDepthMarketData = ctpDepthMarketData;
		return this;
	}

	public static final RspMsg ofRtnOrder(CThostFtdcOrderField order) {
		return new RspMsg(RspMsgType.RtnOrder).setRtnOrder(order);
	}

	private RspMsg setRtnOrder(CThostFtdcOrderField rtnOrder) {
		this.rtnOrder = rtnOrder;
		return this;
	}

	public static final RspMsg ofRtnTrade(CThostFtdcTradeField trade) {
		return new RspMsg(RspMsgType.RtnTrade).setRtnTrade(trade);
	}

	private RspMsg setRtnTrade(CThostFtdcTradeField rtnTrade) {
		this.rtnTrade = rtnTrade;
		return this;
	}

	public static final RspMsg ofRspOrderInsert(CThostFtdcInputOrderField rspOrderInsert) {
		return new RspMsg(RspMsgType.RspOrderInsert).setRspOrderInsert(rspOrderInsert);
	}

	private RspMsg setRspOrderInsert(CThostFtdcInputOrderField rspOrderInsert) {
		this.rspOrderInsert = rspOrderInsert;
		return this;
	}

	public static final RspMsg ofRspOrderAction(CThostFtdcInputOrderActionField rspOrderAction) {
		return new RspMsg(RspMsgType.RspOrderInsert).setRspOrderAction(rspOrderAction);
	}

	private RspMsg setRspOrderAction(CThostFtdcInputOrderActionField rspOrderAction) {
		this.rspOrderAction = rspOrderAction;
		return this;
	}

	public static final RspMsg ofErrRtnOrderInsert(CThostFtdcInputOrderField errRtnOrderInsert) {
		return new RspMsg(RspMsgType.ErrRtnOrderInsert).setErrRtnOrderInsert(errRtnOrderInsert);
	}

	private RspMsg setErrRtnOrderInsert(CThostFtdcInputOrderField errRtnOrderInsert) {
		this.errRtnOrderInsert = errRtnOrderInsert;
		return this;
	}

	public static final RspMsg ofErrRtnOrderAction(CThostFtdcOrderActionField errRtnOrderAction) {
		return new RspMsg(RspMsgType.ErrRtnOrderAction).setErrRtnOrderAction(errRtnOrderAction);
	}

	public RspMsg setErrRtnOrderAction(CThostFtdcOrderActionField errRtnOrderAction) {
		this.errRtnOrderAction = errRtnOrderAction;
		return this;
	}

	private RspMsg(RspMsgType type) {
		this.type = type;
	}

	public RspMsgType getType() {
		return type;
	}

	public CThostFtdcOrderField getRtnOrder() {
		return rtnOrder;
	}

	public CThostFtdcTradeField getRtnTrade() {
		return rtnTrade;
	}

	public CThostFtdcInputOrderField getRspOrderInsert() {
		return rspOrderInsert;
	}

	public CThostFtdcInputOrderActionField getRspOrderAction() {
		return rspOrderAction;
	}

	public CThostFtdcInputOrderField getErrRtnOrderInsert() {
		return errRtnOrderInsert;
	}

	public CThostFtdcOrderActionField getErrRtnOrderAction() {
		return errRtnOrderAction;
	}

}
