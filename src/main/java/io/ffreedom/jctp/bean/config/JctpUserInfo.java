package io.ffreedom.jctp.bean.config;

public class JctpUserInfo {

	private String traderAddress;
	private String mdAddress;

	private String brokerId;
	private String investorId;
	private String accountId;
	private String userId;
	private String userProductInfo;
	private String password;
	private String authCode;

	private String tradingDay;
	private String currencyId;

	public static final JctpUserInfo newEmpty() {
		return new JctpUserInfo();
	}

	public String getTraderAddress() {
		return traderAddress;
	}

	public String getMdAddress() {
		return mdAddress;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public String getInvestorId() {
		return investorId;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserProductInfo() {
		return userProductInfo;
	}

	public String getPassword() {
		return password;
	}

	public String getAuthCode() {
		return authCode;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public JctpUserInfo setTraderAddress(String traderAddress) {
		this.traderAddress = traderAddress;
		return this;
	}

	public JctpUserInfo setMdAddress(String mdAddress) {
		this.mdAddress = mdAddress;
		return this;
	}

	public JctpUserInfo setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	public JctpUserInfo setInvestorId(String investorId) {
		this.investorId = investorId;
		return this;
	}

	public JctpUserInfo setAccountId(String accountId) {
		this.accountId = accountId;
		return this;
	}

	public JctpUserInfo setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public JctpUserInfo setUserProductInfo(String userProductInfo) {
		this.userProductInfo = userProductInfo;
		return this;
	}

	public JctpUserInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public JctpUserInfo setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}

	public JctpUserInfo setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
		return this;
	}

	public JctpUserInfo setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
		return this;
	}

}
