/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcQryBulletinField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcQryBulletinField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcQryBulletinField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcQryBulletinField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcQryBulletinField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcQryBulletinField_ExchangeID_get(swigCPtr, this);
  }

  public void setBulletinID(int value) {
    thosttraderapiJNI.CThostFtdcQryBulletinField_BulletinID_set(swigCPtr, this, value);
  }

  public int getBulletinID() {
    return thosttraderapiJNI.CThostFtdcQryBulletinField_BulletinID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    thosttraderapiJNI.CThostFtdcQryBulletinField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return thosttraderapiJNI.CThostFtdcQryBulletinField_SequenceNo_get(swigCPtr, this);
  }

  public void setNewsType(String value) {
    thosttraderapiJNI.CThostFtdcQryBulletinField_NewsType_set(swigCPtr, this, value);
  }

  public String getNewsType() {
    return thosttraderapiJNI.CThostFtdcQryBulletinField_NewsType_get(swigCPtr, this);
  }

  public void setNewsUrgency(char value) {
    thosttraderapiJNI.CThostFtdcQryBulletinField_NewsUrgency_set(swigCPtr, this, value);
  }

  public char getNewsUrgency() {
    return thosttraderapiJNI.CThostFtdcQryBulletinField_NewsUrgency_get(swigCPtr, this);
  }

  public CThostFtdcQryBulletinField() {
    this(thosttraderapiJNI.new_CThostFtdcQryBulletinField(), true);
  }

}
