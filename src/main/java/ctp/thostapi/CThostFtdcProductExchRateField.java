/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcProductExchRateField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcProductExchRateField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcProductExchRateField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcProductExchRateField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setProductID(String value) {
    thosttraderapiJNI.CThostFtdcProductExchRateField_ProductID_set(swigCPtr, this, value);
  }

  public String getProductID() {
    return thosttraderapiJNI.CThostFtdcProductExchRateField_ProductID_get(swigCPtr, this);
  }

  public void setQuoteCurrencyID(String value) {
    thosttraderapiJNI.CThostFtdcProductExchRateField_QuoteCurrencyID_set(swigCPtr, this, value);
  }

  public String getQuoteCurrencyID() {
    return thosttraderapiJNI.CThostFtdcProductExchRateField_QuoteCurrencyID_get(swigCPtr, this);
  }

  public void setExchangeRate(double value) {
    thosttraderapiJNI.CThostFtdcProductExchRateField_ExchangeRate_set(swigCPtr, this, value);
  }

  public double getExchangeRate() {
    return thosttraderapiJNI.CThostFtdcProductExchRateField_ExchangeRate_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcProductExchRateField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcProductExchRateField_ExchangeID_get(swigCPtr, this);
  }

  public CThostFtdcProductExchRateField() {
    this(thosttraderapiJNI.new_CThostFtdcProductExchRateField(), true);
  }

}
