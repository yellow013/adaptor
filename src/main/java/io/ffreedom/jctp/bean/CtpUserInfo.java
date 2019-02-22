package io.ffreedom.jctp.bean;

public class CtpUserInfo {

	private String TradeAddress = "tcp://180.168.146.187:10000";
	private String MdAddress = "tcp://180.168.146.187:10010";

	private String BrokerId = "9999";
	private String InvestorId = "005853";
	private String UserId = "005853";
	private String AccountId = "005853";
	private String Password = "jinpengpass101";

	private String TradingDay = "20190201";
	private String CurrencyId = "CNY";

	public static final CtpUserInfo newEmpty() {
		return new CtpUserInfo();
	}

	private CtpUserInfo() {
	}

	public String getTradeAddress() {
		return TradeAddress;
	}

	public CtpUserInfo setTradeAddress(String tradeAddress) {
		TradeAddress = tradeAddress;
		return this;
	}

	public String getMdAddress() {
		return MdAddress;
	}

	public CtpUserInfo setMdAddress(String mdAddress) {
		MdAddress = mdAddress;
		return this;
	}

	public String getBrokerId() {
		return BrokerId;
	}

	public CtpUserInfo setBrokerId(String brokerId) {
		BrokerId = brokerId;
		return this;
	}

	public String getInvestorId() {
		return InvestorId;
	}

	public CtpUserInfo setInvestorId(String investorId) {
		InvestorId = investorId;
		return this;
	}

	public String getUserId() {
		return UserId;
	}

	public CtpUserInfo setUserId(String userId) {
		UserId = userId;
		return this;
	}

	public String getAccountId() {
		return AccountId;
	}

	public CtpUserInfo setAccountId(String accountId) {
		AccountId = accountId;
		return this;
	}

	public String getPassword() {
		return Password;
	}

	public CtpUserInfo setPassword(String password) {
		Password = password;
		return this;
	}

	public String getTradingDay() {
		return TradingDay;
	}

	public CtpUserInfo setTradingDay(String tradingDay) {
		TradingDay = tradingDay;
		return this;
	}

	public String getCurrencyId() {
		return CurrencyId;
	}

	public CtpUserInfo setCurrencyId(String currencyId) {
		CurrencyId = currencyId;
		return this;
	}

}
