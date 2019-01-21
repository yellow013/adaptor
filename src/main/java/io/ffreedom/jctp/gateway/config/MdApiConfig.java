package io.ffreedom.jctp.gateway.config;

public class MdApiConfig extends ApiConfig<MdApiConfig> {

	private String mdAddress;

	public String getMdAddress() {
		return mdAddress;
	}

	public MdApiConfig setMdAddress(String mdAddress) {
		this.mdAddress = mdAddress;
		return this;
	}

	@Override
	public MdApiConfig setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	@Override
	public MdApiConfig setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Override
	public MdApiConfig setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public MdApiConfig setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}

}
