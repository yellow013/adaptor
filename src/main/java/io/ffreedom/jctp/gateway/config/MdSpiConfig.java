package io.ffreedom.jctp.gateway.config;

public class MdSpiConfig extends SpiConfig<MdSpiConfig> {

	private String mdAddress;

	public String getMdAddress() {
		return mdAddress;
	}

	public MdSpiConfig setMdAddress(String mdAddress) {
		this.mdAddress = mdAddress;
		return this;
	}

	@Override
	public MdSpiConfig setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	@Override
	public MdSpiConfig setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Override
	public MdSpiConfig setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public MdSpiConfig setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}

}
