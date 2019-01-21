package io.ffreedom.jctp.gateway.config;

/**
 * @author Administrator
 *
 */
public class TdApiConfig extends ApiConfig<TdApiConfig> {

	private String tdAddress;

	public String getTdAddress() {
		return tdAddress;
	}

	public TdApiConfig setTdAddress(String tdAddress) {
		this.tdAddress = tdAddress;
		return this;
	}

	@Override
	public TdApiConfig setBrokerId(String brokerId) {
		this.brokerId = brokerId;
		return this;
	}

	@Override
	public TdApiConfig setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Override
	public TdApiConfig setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public TdApiConfig setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}

}
