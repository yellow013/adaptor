/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcQryTraderOfferField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcQryTraderOfferField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcQryTraderOfferField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcQryTraderOfferField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcQryTraderOfferField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcQryTraderOfferField_ExchangeID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    thosttraderapiJNI.CThostFtdcQryTraderOfferField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return thosttraderapiJNI.CThostFtdcQryTraderOfferField_ParticipantID_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    thosttraderapiJNI.CThostFtdcQryTraderOfferField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return thosttraderapiJNI.CThostFtdcQryTraderOfferField_TraderID_get(swigCPtr, this);
  }

  public CThostFtdcQryTraderOfferField() {
    this(thosttraderapiJNI.new_CThostFtdcQryTraderOfferField(), true);
  }

}
