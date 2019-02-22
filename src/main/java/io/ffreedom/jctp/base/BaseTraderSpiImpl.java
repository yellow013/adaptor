package io.ffreedom.jctp.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ctp.thostapi.CThostFtdcTraderApi;
import ctp.thostapi.CThostFtdcTraderSpi;

public abstract class BaseTraderSpiImpl extends CThostFtdcTraderSpi {

	protected CThostFtdcTraderApi traderApi;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	public BaseTraderSpiImpl(CThostFtdcTraderApi traderApi) {
		this.traderApi = traderApi;
	}

}
