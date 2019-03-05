package io.ffreedom.jctp.bean;

public class CtpUserInfo {

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

	public static final CtpUserInfo newEmpty() {
		return new CtpUserInfo();
	}

	private CtpUserInfo() {
	}

	public String getTraderAddress() {
		return traderAddress;
	}

	public CtpUserInfo setTraderAddress(String traderAddress) {
		this.traderAddress = traderAddress;
		return this;
	}

	public String getMdAddress() {
		return mdAddress;
	}

	public CtpUserInfo setMdAddress(String mdAddress) {
		this.mdAddress = mdAddress;
		return this;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public CtpUserInfo setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	public String getInvestorId() {
		return investorId;
	}

	public CtpUserInfo setInvestorId(String investorId) {
		this.investorId = investorId;
		return this;
	}

	public String getAccountId() {
		return accountId;
	}

	public CtpUserInfo setAccountId(String accountId) {
		this.accountId = accountId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public CtpUserInfo setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUserProductInfo() {
		return userProductInfo;
	}

	public CtpUserInfo setUserProductInfo(String userProductInfo) {
		this.userProductInfo = userProductInfo;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public CtpUserInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public CtpUserInfo setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
		return this;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public CtpUserInfo setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
		return this;
	}

}
