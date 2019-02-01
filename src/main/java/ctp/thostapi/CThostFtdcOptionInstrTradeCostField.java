/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcOptionInstrTradeCostField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcOptionInstrTradeCostField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcOptionInstrTradeCostField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcOptionInstrTradeCostField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InstrumentID_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_HedgeFlag_get(swigCPtr, this);
  }

  public void setFixedMargin(double value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_FixedMargin_set(swigCPtr, this, value);
  }

  public double getFixedMargin() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_FixedMargin_get(swigCPtr, this);
  }

  public void setMiniMargin(double value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_MiniMargin_set(swigCPtr, this, value);
  }

  public double getMiniMargin() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_MiniMargin_get(swigCPtr, this);
  }

  public void setRoyalty(double value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_Royalty_set(swigCPtr, this, value);
  }

  public double getRoyalty() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_Royalty_get(swigCPtr, this);
  }

  public void setExchFixedMargin(double value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchFixedMargin_set(swigCPtr, this, value);
  }

  public double getExchFixedMargin() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchFixedMargin_get(swigCPtr, this);
  }

  public void setExchMiniMargin(double value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchMiniMargin_set(swigCPtr, this, value);
  }

  public double getExchMiniMargin() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchMiniMargin_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_ExchangeID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thosttraderapiJNI.CThostFtdcOptionInstrTradeCostField_InvestUnitID_get(swigCPtr, this);
  }

  public CThostFtdcOptionInstrTradeCostField() {
    this(thosttraderapiJNI.new_CThostFtdcOptionInstrTradeCostField(), true);
  }

}
