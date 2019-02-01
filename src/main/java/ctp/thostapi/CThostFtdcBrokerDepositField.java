/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcBrokerDepositField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcBrokerDepositField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcBrokerDepositField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcBrokerDepositField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradingDay(String value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_TradingDay_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_BrokerID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_ParticipantID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_ExchangeID_get(swigCPtr, this);
  }

  public void setPreBalance(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_PreBalance_set(swigCPtr, this, value);
  }

  public double getPreBalance() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_PreBalance_get(swigCPtr, this);
  }

  public void setCurrMargin(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_CurrMargin_set(swigCPtr, this, value);
  }

  public double getCurrMargin() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_CurrMargin_get(swigCPtr, this);
  }

  public void setCloseProfit(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_CloseProfit_set(swigCPtr, this, value);
  }

  public double getCloseProfit() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_CloseProfit_get(swigCPtr, this);
  }

  public void setBalance(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_Balance_set(swigCPtr, this, value);
  }

  public double getBalance() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_Balance_get(swigCPtr, this);
  }

  public void setDeposit(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_Deposit_set(swigCPtr, this, value);
  }

  public double getDeposit() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_Deposit_get(swigCPtr, this);
  }

  public void setWithdraw(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_Withdraw_set(swigCPtr, this, value);
  }

  public double getWithdraw() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_Withdraw_get(swigCPtr, this);
  }

  public void setAvailable(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_Available_set(swigCPtr, this, value);
  }

  public double getAvailable() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_Available_get(swigCPtr, this);
  }

  public void setReserve(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_Reserve_set(swigCPtr, this, value);
  }

  public double getReserve() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_Reserve_get(swigCPtr, this);
  }

  public void setFrozenMargin(double value) {
    thosttraderapiJNI.CThostFtdcBrokerDepositField_FrozenMargin_set(swigCPtr, this, value);
  }

  public double getFrozenMargin() {
    return thosttraderapiJNI.CThostFtdcBrokerDepositField_FrozenMargin_get(swigCPtr, this);
  }

  public CThostFtdcBrokerDepositField() {
    this(thosttraderapiJNI.new_CThostFtdcBrokerDepositField(), true);
  }

}
