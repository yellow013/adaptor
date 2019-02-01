/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package ctp.thostapi;

public class CThostFtdcReqRepealField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcReqRepealField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcReqRepealField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttraderapiJNI.delete_CThostFtdcReqRepealField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRepealTimeInterval(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_RepealTimeInterval_set(swigCPtr, this, value);
  }

  public int getRepealTimeInterval() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_RepealTimeInterval_get(swigCPtr, this);
  }

  public void setRepealedTimes(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_RepealedTimes_set(swigCPtr, this, value);
  }

  public int getRepealedTimes() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_RepealedTimes_get(swigCPtr, this);
  }

  public void setBankRepealFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankRepealFlag_set(swigCPtr, this, value);
  }

  public char getBankRepealFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankRepealFlag_get(swigCPtr, this);
  }

  public void setBrokerRepealFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BrokerRepealFlag_set(swigCPtr, this, value);
  }

  public char getBrokerRepealFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BrokerRepealFlag_get(swigCPtr, this);
  }

  public void setPlateRepealSerial(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_PlateRepealSerial_set(swigCPtr, this, value);
  }

  public int getPlateRepealSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_PlateRepealSerial_get(swigCPtr, this);
  }

  public void setBankRepealSerial(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankRepealSerial_set(swigCPtr, this, value);
  }

  public String getBankRepealSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankRepealSerial_get(swigCPtr, this);
  }

  public void setFutureRepealSerial(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_FutureRepealSerial_set(swigCPtr, this, value);
  }

  public int getFutureRepealSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_FutureRepealSerial_get(swigCPtr, this);
  }

  public void setTradeCode(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TradeCode_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankID_get(swigCPtr, this);
  }

  public void setBankBranchID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankBranchID_set(swigCPtr, this, value);
  }

  public String getBankBranchID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankBranchID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BrokerID_get(swigCPtr, this);
  }

  public void setBrokerBranchID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BrokerBranchID_set(swigCPtr, this, value);
  }

  public String getBrokerBranchID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BrokerBranchID_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TradeTime_get(swigCPtr, this);
  }

  public void setBankSerial(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankSerial_set(swigCPtr, this, value);
  }

  public String getBankSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankSerial_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TradingDay_get(swigCPtr, this);
  }

  public void setPlateSerial(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_PlateSerial_set(swigCPtr, this, value);
  }

  public int getPlateSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_PlateSerial_get(swigCPtr, this);
  }

  public void setLastFragment(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_LastFragment_set(swigCPtr, this, value);
  }

  public char getLastFragment() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_LastFragment_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_SessionID_get(swigCPtr, this);
  }

  public void setCustomerName(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_CustomerName_set(swigCPtr, this, value);
  }

  public String getCustomerName() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_CustomerName_get(swigCPtr, this);
  }

  public void setIdCardType(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_IdCardType_set(swigCPtr, this, value);
  }

  public char getIdCardType() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_IdCardType_get(swigCPtr, this);
  }

  public void setIdentifiedCardNo(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_IdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getIdentifiedCardNo() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_IdentifiedCardNo_get(swigCPtr, this);
  }

  public void setCustType(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_CustType_set(swigCPtr, this, value);
  }

  public char getCustType() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_CustType_get(swigCPtr, this);
  }

  public void setBankAccount(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankAccount_set(swigCPtr, this, value);
  }

  public String getBankAccount() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankAccount_get(swigCPtr, this);
  }

  public void setBankPassWord(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankPassWord_set(swigCPtr, this, value);
  }

  public String getBankPassWord() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankPassWord_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_AccountID_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_Password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_Password_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_InstallID_get(swigCPtr, this);
  }

  public void setFutureSerial(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_FutureSerial_set(swigCPtr, this, value);
  }

  public int getFutureSerial() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_FutureSerial_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_UserID_get(swigCPtr, this);
  }

  public void setVerifyCertNoFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_VerifyCertNoFlag_set(swigCPtr, this, value);
  }

  public char getVerifyCertNoFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_VerifyCertNoFlag_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_CurrencyID_get(swigCPtr, this);
  }

  public void setTradeAmount(double value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TradeAmount_set(swigCPtr, this, value);
  }

  public double getTradeAmount() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TradeAmount_get(swigCPtr, this);
  }

  public void setFutureFetchAmount(double value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_FutureFetchAmount_set(swigCPtr, this, value);
  }

  public double getFutureFetchAmount() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_FutureFetchAmount_get(swigCPtr, this);
  }

  public void setFeePayFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_FeePayFlag_set(swigCPtr, this, value);
  }

  public char getFeePayFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_FeePayFlag_get(swigCPtr, this);
  }

  public void setCustFee(double value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_CustFee_set(swigCPtr, this, value);
  }

  public double getCustFee() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_CustFee_get(swigCPtr, this);
  }

  public void setBrokerFee(double value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BrokerFee_set(swigCPtr, this, value);
  }

  public double getBrokerFee() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BrokerFee_get(swigCPtr, this);
  }

  public void setMessage(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_Message_set(swigCPtr, this, value);
  }

  public String getMessage() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_Message_get(swigCPtr, this);
  }

  public void setDigest(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_Digest_set(swigCPtr, this, value);
  }

  public String getDigest() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_Digest_get(swigCPtr, this);
  }

  public void setBankAccType(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankAccType_set(swigCPtr, this, value);
  }

  public char getBankAccType() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankAccType_get(swigCPtr, this);
  }

  public void setDeviceID(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_DeviceID_set(swigCPtr, this, value);
  }

  public String getDeviceID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_DeviceID_get(swigCPtr, this);
  }

  public void setBankSecuAccType(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankSecuAccType_set(swigCPtr, this, value);
  }

  public char getBankSecuAccType() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankSecuAccType_get(swigCPtr, this);
  }

  public void setBrokerIDByBank(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BrokerIDByBank_set(swigCPtr, this, value);
  }

  public String getBrokerIDByBank() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BrokerIDByBank_get(swigCPtr, this);
  }

  public void setBankSecuAcc(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankSecuAcc_set(swigCPtr, this, value);
  }

  public String getBankSecuAcc() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankSecuAcc_get(swigCPtr, this);
  }

  public void setBankPwdFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_BankPwdFlag_set(swigCPtr, this, value);
  }

  public char getBankPwdFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_BankPwdFlag_get(swigCPtr, this);
  }

  public void setSecuPwdFlag(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_SecuPwdFlag_set(swigCPtr, this, value);
  }

  public char getSecuPwdFlag() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_SecuPwdFlag_get(swigCPtr, this);
  }

  public void setOperNo(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_OperNo_set(swigCPtr, this, value);
  }

  public String getOperNo() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_OperNo_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_RequestID_get(swigCPtr, this);
  }

  public void setTID(int value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TID_set(swigCPtr, this, value);
  }

  public int getTID() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TID_get(swigCPtr, this);
  }

  public void setTransferStatus(char value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_TransferStatus_set(swigCPtr, this, value);
  }

  public char getTransferStatus() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_TransferStatus_get(swigCPtr, this);
  }

  public void setLongCustomerName(String value) {
    thosttraderapiJNI.CThostFtdcReqRepealField_LongCustomerName_set(swigCPtr, this, value);
  }

  public String getLongCustomerName() {
    return thosttraderapiJNI.CThostFtdcReqRepealField_LongCustomerName_get(swigCPtr, this);
  }

  public CThostFtdcReqRepealField() {
    this(thosttraderapiJNI.new_CThostFtdcReqRepealField(), true);
  }

}
