/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcMarketDataUpdateTimeField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcMarketDataUpdateTimeField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcMarketDataUpdateTimeField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcMarketDataUpdateTimeField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_InstrumentID_get(swigCPtr, this);
  }

  public void setUpdateTime(String value) {
    thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_UpdateTime_set(swigCPtr, this, value);
  }

  public String getUpdateTime() {
    return thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_UpdateTime_get(swigCPtr, this);
  }

  public void setUpdateMillisec(int value) {
    thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_UpdateMillisec_set(swigCPtr, this, value);
  }

  public int getUpdateMillisec() {
    return thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_UpdateMillisec_get(swigCPtr, this);
  }

  public void setActionDay(String value) {
    thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_ActionDay_set(swigCPtr, this, value);
  }

  public String getActionDay() {
    return thosttraderapiJNI.CThostFtdcMarketDataUpdateTimeField_ActionDay_get(swigCPtr, this);
  }

  public CThostFtdcMarketDataUpdateTimeField() {
    this(thosttraderapiJNI.new_CThostFtdcMarketDataUpdateTimeField(), true);
  }

}
