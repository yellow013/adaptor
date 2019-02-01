/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcBulletinField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcBulletinField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcBulletinField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcBulletinField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcBulletinField_ExchangeID_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttraderapiJNI.CThostFtdcBulletinField_TradingDay_get(swigCPtr, this);
  }

  public void setBulletinID(int value) {
    thosttraderapiJNI.CThostFtdcBulletinField_BulletinID_set(swigCPtr, this, value);
  }

  public int getBulletinID() {
    return thosttraderapiJNI.CThostFtdcBulletinField_BulletinID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    thosttraderapiJNI.CThostFtdcBulletinField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return thosttraderapiJNI.CThostFtdcBulletinField_SequenceNo_get(swigCPtr, this);
  }

  public void setNewsType(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_NewsType_set(swigCPtr, this, value);
  }

  public String getNewsType() {
    return thosttraderapiJNI.CThostFtdcBulletinField_NewsType_get(swigCPtr, this);
  }

  public void setNewsUrgency(char value) {
    thosttraderapiJNI.CThostFtdcBulletinField_NewsUrgency_set(swigCPtr, this, value);
  }

  public char getNewsUrgency() {
    return thosttraderapiJNI.CThostFtdcBulletinField_NewsUrgency_get(swigCPtr, this);
  }

  public void setSendTime(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_SendTime_set(swigCPtr, this, value);
  }

  public String getSendTime() {
    return thosttraderapiJNI.CThostFtdcBulletinField_SendTime_get(swigCPtr, this);
  }

  public void setAbstract(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_Abstract_set(swigCPtr, this, value);
  }

  public String getAbstract() {
    return thosttraderapiJNI.CThostFtdcBulletinField_Abstract_get(swigCPtr, this);
  }

  public void setComeFrom(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_ComeFrom_set(swigCPtr, this, value);
  }

  public String getComeFrom() {
    return thosttraderapiJNI.CThostFtdcBulletinField_ComeFrom_get(swigCPtr, this);
  }

  public void setContent(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_Content_set(swigCPtr, this, value);
  }

  public String getContent() {
    return thosttraderapiJNI.CThostFtdcBulletinField_Content_get(swigCPtr, this);
  }

  public void setURLLink(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_URLLink_set(swigCPtr, this, value);
  }

  public String getURLLink() {
    return thosttraderapiJNI.CThostFtdcBulletinField_URLLink_get(swigCPtr, this);
  }

  public void setMarketID(String value) {
    thosttraderapiJNI.CThostFtdcBulletinField_MarketID_set(swigCPtr, this, value);
  }

  public String getMarketID() {
    return thosttraderapiJNI.CThostFtdcBulletinField_MarketID_get(swigCPtr, this);
  }

  public CThostFtdcBulletinField() {
    this(thosttraderapiJNI.new_CThostFtdcBulletinField(), true);
  }

}
