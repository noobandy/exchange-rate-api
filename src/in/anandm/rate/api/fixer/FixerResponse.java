package in.anandm.rate.api.fixer;

import java.util.Map;

public class FixerResponse {
	// TODO:

	/*
	 * { "success":false, "error":{ "code":105,
	 * "type":"base_currency_access_restricted" } }
	 * 
	 * { "success":true, "timestamp":1537512845, "base":"EUR",
	 * "date":"2018-09-21", "rates":{ "EUR":1, "INR":84.634127, "USD":1.178502,
	 * } }
	 */
	
	private boolean success;
	private long timestamp;
	private String base;
	private Map<String, Float> rates;

	public FixerResponse() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Float> getRates() {
		return rates;
	}

	public void setRates(Map<String, Float> rates) {
		this.rates = rates;
	}

}
