/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcQryExchangeRateField {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	protected CThostFtdcQryExchangeRateField(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(CThostFtdcQryExchangeRateField obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				thosttraderapiJNI.delete_CThostFtdcQryExchangeRateField(swigCPtr);
			}
			swigCPtr = 0;
		}
	}

	public void setBrokerID(String value) {
		thosttraderapiJNI.CThostFtdcQryExchangeRateField_BrokerID_set(swigCPtr, this, value);
	}

	public String getBrokerID() {
		return thosttraderapiJNI.CThostFtdcQryExchangeRateField_BrokerID_get(swigCPtr, this);
	}

	public void setFromCurrencyID(String value) {
		thosttraderapiJNI.CThostFtdcQryExchangeRateField_FromCurrencyID_set(swigCPtr, this, value);
	}

	public String getFromCurrencyID() {
		return thosttraderapiJNI.CThostFtdcQryExchangeRateField_FromCurrencyID_get(swigCPtr, this);
	}

	public void setToCurrencyID(String value) {
		thosttraderapiJNI.CThostFtdcQryExchangeRateField_ToCurrencyID_set(swigCPtr, this, value);
	}

	public String getToCurrencyID() {
		return thosttraderapiJNI.CThostFtdcQryExchangeRateField_ToCurrencyID_get(swigCPtr, this);
	}

	public CThostFtdcQryExchangeRateField() {
		this(thosttraderapiJNI.new_CThostFtdcQryExchangeRateField(), true);
	}

}
