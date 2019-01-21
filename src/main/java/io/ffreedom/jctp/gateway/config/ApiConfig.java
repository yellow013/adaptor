package io.ffreedom.jctp.gateway.config;

/**
 * @author Administrator
 *
 */
public abstract class ApiConfig<T extends ApiConfig<T>> {

	protected String brokerId;
	protected String userId;
	protected String password;
	protected String authCode;

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

}
