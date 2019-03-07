package io.ffreedom.jctp.bean;

public class JctpUserInfo {

	private String traderAddress = "tcp://180.168.146.187:10000";
	private String mdAddress = "tcp://180.168.146.187:10010";

	private String brokerId = "9999";
	private String investorId = "005853";
	private String accountId = "005853";
	private String userId = "005853";
	private String userProductInfo;
	private String password = "jinpengpass101";

	private String tradingDay = "20190201";
	private String currencyId = "CNY";

	public static final JctpUserInfo newEmpty() {
		return new JctpUserInfo();
	}

	private JctpUserInfo() {
	}

	public String getTraderAddress() {
		return traderAddress;
	}

	public JctpUserInfo setTraderAddress(String traderAddress) {
		this.traderAddress = traderAddress;
		return this;
	}

	public String getMdAddress() {
		return mdAddress;
	}

	public JctpUserInfo setMdAddress(String mdAddress) {
		this.mdAddress = mdAddress;
		return this;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public JctpUserInfo setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	public String getInvestorId() {
		return investorId;
	}

	public JctpUserInfo setInvestorId(String investorId) {
		this.investorId = investorId;
		return this;
	}

	public String getAccountId() {
		return accountId;
	}

	public JctpUserInfo setAccountId(String accountId) {
		this.accountId = accountId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public JctpUserInfo setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUserProductInfo() {
		return userProductInfo;
	}

	public JctpUserInfo setUserProductInfo(String userProductInfo) {
		this.userProductInfo = userProductInfo;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public JctpUserInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public JctpUserInfo setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
		return this;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public JctpUserInfo setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
		return this;
	}

}
