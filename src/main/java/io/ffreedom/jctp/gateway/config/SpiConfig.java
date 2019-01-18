package io.ffreedom.jctp.gateway.config;

/**
 * @author Administrator
 *
 */
public abstract class SpiConfig<T extends SpiConfig<T>> {

	protected String brokerId;
	protected String userId;
	protected String password;
	protected String authCode;
	protected String gatewayId;
	protected String gatewayName;

	public String getBrokerId() {
		return brokerId;
	}

	abstract public T setBrokerId(String brokerId);

	public String getUserId() {
		return userId;
	}

	abstract public T setUserId(String userId);

	public String getPassword() {
		return password;
	}

	abstract public T setPassword(String password);

	public String getAuthCode() {
		return authCode;
	}

	abstract public T setAuthCode(String authCode);

	public String getGatewayId() {
		return gatewayId;
	}

	abstract public T setGatewayId(String gatewayId);

	public String getGatewayName() {
		return gatewayName;
	}

	abstract public T setGatewayName(String gatewayName);

}
