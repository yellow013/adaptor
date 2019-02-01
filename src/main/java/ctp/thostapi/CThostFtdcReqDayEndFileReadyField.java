/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcReqDayEndFileReadyField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcReqDayEndFileReadyField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcReqDayEndFileReadyField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcReqDayEndFileReadyField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradeCode(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeCode_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankID_get(swigCPtr, this);
  }

  public void setBankBranchID(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankBranchID_set(swigCPtr, this, value);
  }

  public String getBankBranchID() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankBranchID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BrokerID_get(swigCPtr, this);
  }

  public void setBrokerBranchID(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BrokerBranchID_set(swigCPtr, this, value);
  }

  public String getBrokerBranchID() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BrokerBranchID_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradeTime_get(swigCPtr, this);
  }

  public void setBankSerial(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankSerial_set(swigCPtr, this, value);
  }

  public String getBankSerial() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_BankSerial_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_TradingDay_get(swigCPtr, this);
  }

  public void setPlateSerial(int value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_PlateSerial_set(swigCPtr, this, value);
  }

  public int getPlateSerial() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_PlateSerial_get(swigCPtr, this);
  }

  public void setLastFragment(char value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_LastFragment_set(swigCPtr, this, value);
  }

  public char getLastFragment() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_LastFragment_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_SessionID_get(swigCPtr, this);
  }

  public void setFileBusinessCode(char value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_FileBusinessCode_set(swigCPtr, this, value);
  }

  public char getFileBusinessCode() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_FileBusinessCode_get(swigCPtr, this);
  }

  public void setDigest(String value) {
    thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_Digest_set(swigCPtr, this, value);
  }

  public String getDigest() {
    return thosttraderapiJNI.CThostFtdcReqDayEndFileReadyField_Digest_get(swigCPtr, this);
  }

  public CThostFtdcReqDayEndFileReadyField() {
    this(thosttraderapiJNI.new_CThostFtdcReqDayEndFileReadyField(), true);
  }

}
