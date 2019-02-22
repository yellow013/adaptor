package io.ffreedom.jctp.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcMdApi;
import ctp.thostapi.CThostFtdcMdSpi;

public abstract class BaseMdSpiImpl extends CThostFtdcMdSpi {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected CThostFtdcMdApi mdApi;

	protected int requestId;

	public BaseMdSpiImpl(CThostFtdcMdApi mdApi) {
		this.mdApi = mdApi;
	}
	
}
