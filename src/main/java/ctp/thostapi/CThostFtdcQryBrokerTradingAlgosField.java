/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcQryBrokerTradingAlgosField {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	protected CThostFtdcQryBrokerTradingAlgosField(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(CThostFtdcQryBrokerTradingAlgosField obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				thosttraderapiJNI.delete_CThostFtdcQryBrokerTradingAlgosField(swigCPtr);
			}
			swigCPtr = 0;
		}
	}

	public void setBrokerID(String value) {
		thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_BrokerID_set(swigCPtr, this, value);
	}

	public String getBrokerID() {
		return thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_BrokerID_get(swigCPtr, this);
	}

	public void setExchangeID(String value) {
		thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_ExchangeID_set(swigCPtr, this, value);
	}

	public String getExchangeID() {
		return thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_ExchangeID_get(swigCPtr, this);
	}

	public void setInstrumentID(String value) {
		thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_InstrumentID_set(swigCPtr, this, value);
	}

	public String getInstrumentID() {
		return thosttraderapiJNI.CThostFtdcQryBrokerTradingAlgosField_InstrumentID_get(swigCPtr, this);
	}

	public CThostFtdcQryBrokerTradingAlgosField() {
		this(thosttraderapiJNI.new_CThostFtdcQryBrokerTradingAlgosField(), true);
	}

}
