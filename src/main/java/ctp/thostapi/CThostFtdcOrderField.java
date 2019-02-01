/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttraderapiJNI.CThostFtdcOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttraderapiJNI.CThostFtdcOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttraderapiJNI.CThostFtdcOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setOrderRef(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderRef_set(swigCPtr, this, value);
  }

  public String getOrderRef() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttraderapiJNI.CThostFtdcOrderField_UserID_get(swigCPtr, this);
  }

  public void setOrderPriceType(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderPriceType_set(swigCPtr, this, value);
  }

  public char getOrderPriceType() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderPriceType_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return thosttraderapiJNI.CThostFtdcOrderField_Direction_get(swigCPtr, this);
  }

  public void setCombOffsetFlag(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_CombOffsetFlag_set(swigCPtr, this, value);
  }

  public String getCombOffsetFlag() {
    return thosttraderapiJNI.CThostFtdcOrderField_CombOffsetFlag_get(swigCPtr, this);
  }

  public void setCombHedgeFlag(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_CombHedgeFlag_set(swigCPtr, this, value);
  }

  public String getCombHedgeFlag() {
    return thosttraderapiJNI.CThostFtdcOrderField_CombHedgeFlag_get(swigCPtr, this);
  }

  public void setLimitPrice(double value) {
    thosttraderapiJNI.CThostFtdcOrderField_LimitPrice_set(swigCPtr, this, value);
  }

  public double getLimitPrice() {
    return thosttraderapiJNI.CThostFtdcOrderField_LimitPrice_get(swigCPtr, this);
  }

  public void setVolumeTotalOriginal(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_VolumeTotalOriginal_set(swigCPtr, this, value);
  }

  public int getVolumeTotalOriginal() {
    return thosttraderapiJNI.CThostFtdcOrderField_VolumeTotalOriginal_get(swigCPtr, this);
  }

  public void setTimeCondition(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_TimeCondition_set(swigCPtr, this, value);
  }

  public char getTimeCondition() {
    return thosttraderapiJNI.CThostFtdcOrderField_TimeCondition_get(swigCPtr, this);
  }

  public void setGTDDate(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_GTDDate_set(swigCPtr, this, value);
  }

  public String getGTDDate() {
    return thosttraderapiJNI.CThostFtdcOrderField_GTDDate_get(swigCPtr, this);
  }

  public void setVolumeCondition(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_VolumeCondition_set(swigCPtr, this, value);
  }

  public char getVolumeCondition() {
    return thosttraderapiJNI.CThostFtdcOrderField_VolumeCondition_get(swigCPtr, this);
  }

  public void setMinVolume(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_MinVolume_set(swigCPtr, this, value);
  }

  public int getMinVolume() {
    return thosttraderapiJNI.CThostFtdcOrderField_MinVolume_get(swigCPtr, this);
  }

  public void setContingentCondition(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_ContingentCondition_set(swigCPtr, this, value);
  }

  public char getContingentCondition() {
    return thosttraderapiJNI.CThostFtdcOrderField_ContingentCondition_get(swigCPtr, this);
  }

  public void setStopPrice(double value) {
    thosttraderapiJNI.CThostFtdcOrderField_StopPrice_set(swigCPtr, this, value);
  }

  public double getStopPrice() {
    return thosttraderapiJNI.CThostFtdcOrderField_StopPrice_get(swigCPtr, this);
  }

  public void setForceCloseReason(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_ForceCloseReason_set(swigCPtr, this, value);
  }

  public char getForceCloseReason() {
    return thosttraderapiJNI.CThostFtdcOrderField_ForceCloseReason_get(swigCPtr, this);
  }

  public void setIsAutoSuspend(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_IsAutoSuspend_set(swigCPtr, this, value);
  }

  public int getIsAutoSuspend() {
    return thosttraderapiJNI.CThostFtdcOrderField_IsAutoSuspend_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return thosttraderapiJNI.CThostFtdcOrderField_BusinessUnit_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttraderapiJNI.CThostFtdcOrderField_RequestID_get(swigCPtr, this);
  }

  public void setOrderLocalID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderLocalID_set(swigCPtr, this, value);
  }

  public String getOrderLocalID() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderLocalID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ParticipantID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ClientID_get(swigCPtr, this);
  }

  public void setExchangeInstID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ExchangeInstID_set(swigCPtr, this, value);
  }

  public String getExchangeInstID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ExchangeInstID_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return thosttraderapiJNI.CThostFtdcOrderField_TraderID_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return thosttraderapiJNI.CThostFtdcOrderField_InstallID_get(swigCPtr, this);
  }

  public void setOrderSubmitStatus(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderSubmitStatus_set(swigCPtr, this, value);
  }

  public char getOrderSubmitStatus() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderSubmitStatus_get(swigCPtr, this);
  }

  public void setNotifySequence(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_NotifySequence_set(swigCPtr, this, value);
  }

  public int getNotifySequence() {
    return thosttraderapiJNI.CThostFtdcOrderField_NotifySequence_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttraderapiJNI.CThostFtdcOrderField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return thosttraderapiJNI.CThostFtdcOrderField_SettlementID_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderSysID_get(swigCPtr, this);
  }

  public void setOrderSource(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderSource_set(swigCPtr, this, value);
  }

  public char getOrderSource() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderSource_get(swigCPtr, this);
  }

  public void setOrderStatus(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderStatus_set(swigCPtr, this, value);
  }

  public char getOrderStatus() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderStatus_get(swigCPtr, this);
  }

  public void setOrderType(char value) {
    thosttraderapiJNI.CThostFtdcOrderField_OrderType_set(swigCPtr, this, value);
  }

  public char getOrderType() {
    return thosttraderapiJNI.CThostFtdcOrderField_OrderType_get(swigCPtr, this);
  }

  public void setVolumeTraded(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_VolumeTraded_set(swigCPtr, this, value);
  }

  public int getVolumeTraded() {
    return thosttraderapiJNI.CThostFtdcOrderField_VolumeTraded_get(swigCPtr, this);
  }

  public void setVolumeTotal(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_VolumeTotal_set(swigCPtr, this, value);
  }

  public int getVolumeTotal() {
    return thosttraderapiJNI.CThostFtdcOrderField_VolumeTotal_get(swigCPtr, this);
  }

  public void setInsertDate(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_InsertDate_set(swigCPtr, this, value);
  }

  public String getInsertDate() {
    return thosttraderapiJNI.CThostFtdcOrderField_InsertDate_get(swigCPtr, this);
  }

  public void setInsertTime(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_InsertTime_set(swigCPtr, this, value);
  }

  public String getInsertTime() {
    return thosttraderapiJNI.CThostFtdcOrderField_InsertTime_get(swigCPtr, this);
  }

  public void setActiveTime(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ActiveTime_set(swigCPtr, this, value);
  }

  public String getActiveTime() {
    return thosttraderapiJNI.CThostFtdcOrderField_ActiveTime_get(swigCPtr, this);
  }

  public void setSuspendTime(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_SuspendTime_set(swigCPtr, this, value);
  }

  public String getSuspendTime() {
    return thosttraderapiJNI.CThostFtdcOrderField_SuspendTime_get(swigCPtr, this);
  }

  public void setUpdateTime(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_UpdateTime_set(swigCPtr, this, value);
  }

  public String getUpdateTime() {
    return thosttraderapiJNI.CThostFtdcOrderField_UpdateTime_get(swigCPtr, this);
  }

  public void setCancelTime(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_CancelTime_set(swigCPtr, this, value);
  }

  public String getCancelTime() {
    return thosttraderapiJNI.CThostFtdcOrderField_CancelTime_get(swigCPtr, this);
  }

  public void setActiveTraderID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ActiveTraderID_set(swigCPtr, this, value);
  }

  public String getActiveTraderID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ActiveTraderID_get(swigCPtr, this);
  }

  public void setClearingPartID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ClearingPartID_set(swigCPtr, this, value);
  }

  public String getClearingPartID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ClearingPartID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return thosttraderapiJNI.CThostFtdcOrderField_SequenceNo_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return thosttraderapiJNI.CThostFtdcOrderField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttraderapiJNI.CThostFtdcOrderField_SessionID_get(swigCPtr, this);
  }

  public void setUserProductInfo(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_UserProductInfo_set(swigCPtr, this, value);
  }

  public String getUserProductInfo() {
    return thosttraderapiJNI.CThostFtdcOrderField_UserProductInfo_get(swigCPtr, this);
  }

  public void setStatusMsg(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_StatusMsg_set(swigCPtr, this, value);
  }

  public String getStatusMsg() {
    return thosttraderapiJNI.CThostFtdcOrderField_StatusMsg_get(swigCPtr, this);
  }

  public void setUserForceClose(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_UserForceClose_set(swigCPtr, this, value);
  }

  public int getUserForceClose() {
    return thosttraderapiJNI.CThostFtdcOrderField_UserForceClose_get(swigCPtr, this);
  }

  public void setActiveUserID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_ActiveUserID_set(swigCPtr, this, value);
  }

  public String getActiveUserID() {
    return thosttraderapiJNI.CThostFtdcOrderField_ActiveUserID_get(swigCPtr, this);
  }

  public void setBrokerOrderSeq(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_BrokerOrderSeq_set(swigCPtr, this, value);
  }

  public int getBrokerOrderSeq() {
    return thosttraderapiJNI.CThostFtdcOrderField_BrokerOrderSeq_get(swigCPtr, this);
  }

  public void setRelativeOrderSysID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_RelativeOrderSysID_set(swigCPtr, this, value);
  }

  public String getRelativeOrderSysID() {
    return thosttraderapiJNI.CThostFtdcOrderField_RelativeOrderSysID_get(swigCPtr, this);
  }

  public void setZCETotalTradedVolume(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_ZCETotalTradedVolume_set(swigCPtr, this, value);
  }

  public int getZCETotalTradedVolume() {
    return thosttraderapiJNI.CThostFtdcOrderField_ZCETotalTradedVolume_get(swigCPtr, this);
  }

  public void setIsSwapOrder(int value) {
    thosttraderapiJNI.CThostFtdcOrderField_IsSwapOrder_set(swigCPtr, this, value);
  }

  public int getIsSwapOrder() {
    return thosttraderapiJNI.CThostFtdcOrderField_IsSwapOrder_get(swigCPtr, this);
  }

  public void setBranchID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_BranchID_set(swigCPtr, this, value);
  }

  public String getBranchID() {
    return thosttraderapiJNI.CThostFtdcOrderField_BranchID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thosttraderapiJNI.CThostFtdcOrderField_InvestUnitID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttraderapiJNI.CThostFtdcOrderField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttraderapiJNI.CThostFtdcOrderField_CurrencyID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return thosttraderapiJNI.CThostFtdcOrderField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttraderapiJNI.CThostFtdcOrderField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttraderapiJNI.CThostFtdcOrderField_MacAddress_get(swigCPtr, this);
  }

  public CThostFtdcOrderField() {
    this(thosttraderapiJNI.new_CThostFtdcOrderField(), true);
  }

}
