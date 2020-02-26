/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcBrokerWithdrawAlgorithmField {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	protected CThostFtdcBrokerWithdrawAlgorithmField(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(CThostFtdcBrokerWithdrawAlgorithmField obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				thosttraderapiJNI.delete_CThostFtdcBrokerWithdrawAlgorithmField(swigCPtr);
			}
			swigCPtr = 0;
		}
	}

	public void setBrokerID(String value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_BrokerID_set(swigCPtr, this, value);
	}

	public String getBrokerID() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_BrokerID_get(swigCPtr, this);
	}

	public void setWithdrawAlgorithm(char value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_WithdrawAlgorithm_set(swigCPtr, this, value);
	}

	public char getWithdrawAlgorithm() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_WithdrawAlgorithm_get(swigCPtr, this);
	}

	public void setUsingRatio(double value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_UsingRatio_set(swigCPtr, this, value);
	}

	public double getUsingRatio() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_UsingRatio_get(swigCPtr, this);
	}

	public void setIncludeCloseProfit(char value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_IncludeCloseProfit_set(swigCPtr, this, value);
	}

	public char getIncludeCloseProfit() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_IncludeCloseProfit_get(swigCPtr, this);
	}

	public void setAllWithoutTrade(char value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_AllWithoutTrade_set(swigCPtr, this, value);
	}

	public char getAllWithoutTrade() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_AllWithoutTrade_get(swigCPtr, this);
	}

	public void setAvailIncludeCloseProfit(char value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_AvailIncludeCloseProfit_set(swigCPtr, this, value);
	}

	public char getAvailIncludeCloseProfit() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_AvailIncludeCloseProfit_get(swigCPtr, this);
	}

	public void setIsBrokerUserEvent(int value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_IsBrokerUserEvent_set(swigCPtr, this, value);
	}

	public int getIsBrokerUserEvent() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_IsBrokerUserEvent_get(swigCPtr, this);
	}

	public void setCurrencyID(String value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_CurrencyID_set(swigCPtr, this, value);
	}

	public String getCurrencyID() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_CurrencyID_get(swigCPtr, this);
	}

	public void setFundMortgageRatio(double value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_FundMortgageRatio_set(swigCPtr, this, value);
	}

	public double getFundMortgageRatio() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_FundMortgageRatio_get(swigCPtr, this);
	}

	public void setBalanceAlgorithm(char value) {
		thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_BalanceAlgorithm_set(swigCPtr, this, value);
	}

	public char getBalanceAlgorithm() {
		return thosttraderapiJNI.CThostFtdcBrokerWithdrawAlgorithmField_BalanceAlgorithm_get(swigCPtr, this);
	}

	public CThostFtdcBrokerWithdrawAlgorithmField() {
		this(thosttraderapiJNI.new_CThostFtdcBrokerWithdrawAlgorithmField(), true);
	}

}
