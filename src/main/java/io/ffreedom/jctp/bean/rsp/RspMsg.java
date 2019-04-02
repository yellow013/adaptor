package io.ffreedom.jctp.bean.rsp;

import ctp.thostapi.CThostFtdcInputOrderActionField;
import ctp.thostapi.CThostFtdcInputOrderField;
import ctp.thostapi.CThostFtdcOrderActionField;

public final class RspMsg {

	private RspMsgType type;
	private RspDepthMarketData rspDepthMarketData;

	private RtnOrder rtnOrder;
	private RtnTrade rtnTrade;

	private CThostFtdcInputOrderField rspOrderInsert;
	private CThostFtdcInputOrderActionField rspOrderAction;

	private CThostFtdcInputOrderField errRtnOrderInsert;
	private CThostFtdcOrderActionField errRtnOrderAction;

	public static final RspMsg ofDepthMarketData(RspDepthMarketData depthMarketData) {
		return new RspMsg(RspMsgType.DepthMarketData).setRspDepthMarketData(depthMarketData);
	}

	public RspDepthMarketData getRspDepthMarketData() {
		return rspDepthMarketData;
	}

	private RspMsg setRspDepthMarketData(RspDepthMarketData rspDepthMarketData) {
		this.rspDepthMarketData = rspDepthMarketData;
		return this;
	}

	public static final RspMsg ofRtnOrder(RtnOrder order) {
		return new RspMsg(RspMsgType.RtnOrder).setRtnOrder(order);
	}

	private RspMsg setRtnOrder(RtnOrder rtnOrder) {
		this.rtnOrder = rtnOrder;
		return this;
	}

	public static final RspMsg ofRtnTrade(RtnTrade trade) {
		return new RspMsg(RspMsgType.RtnTrade).setRtnTrade(trade);
	}

	private RspMsg setRtnTrade(RtnTrade rtnTrade) {
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

	public RtnOrder getRtnOrder() {
		return rtnOrder;
	}

	public RtnTrade getRtnTrade() {
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
