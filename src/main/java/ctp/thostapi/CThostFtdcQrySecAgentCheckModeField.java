/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcQrySecAgentCheckModeField {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	protected CThostFtdcQrySecAgentCheckModeField(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(CThostFtdcQrySecAgentCheckModeField obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				thosttraderapiJNI.delete_CThostFtdcQrySecAgentCheckModeField(swigCPtr);
			}
			swigCPtr = 0;
		}
	}

	public void setBrokerID(String value) {
		thosttraderapiJNI.CThostFtdcQrySecAgentCheckModeField_BrokerID_set(swigCPtr, this, value);
	}

	public String getBrokerID() {
		return thosttraderapiJNI.CThostFtdcQrySecAgentCheckModeField_BrokerID_get(swigCPtr, this);
	}

	public void setInvestorID(String value) {
		thosttraderapiJNI.CThostFtdcQrySecAgentCheckModeField_InvestorID_set(swigCPtr, this, value);
	}

	public String getInvestorID() {
		return thosttraderapiJNI.CThostFtdcQrySecAgentCheckModeField_InvestorID_get(swigCPtr, this);
	}

	public CThostFtdcQrySecAgentCheckModeField() {
		this(thosttraderapiJNI.new_CThostFtdcQrySecAgentCheckModeField(), true);
	}

}
