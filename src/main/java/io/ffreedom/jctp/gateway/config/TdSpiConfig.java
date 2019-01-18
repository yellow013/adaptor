package io.ffreedom.jctp.gateway.config;

/**
 * @author Administrator
 *
 */
public class TdSpiConfig extends SpiConfig<TdSpiConfig> {

	private String tdAddress;

	

	public String getTdAddress() {
		return tdAddress;
	}

	public TdSpiConfig setTdAddress(String tdAddress) {
		this.tdAddress = tdAddress;
		return this;
	}

	@Override
	public TdSpiConfig setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	@Override
	public TdSpiConfig setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Override
	public TdSpiConfig setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public TdSpiConfig setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}

	@Override
	public TdSpiConfig setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
		return this;
	}

	@Override
	public TdSpiConfig setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
		return this;
	}

}
