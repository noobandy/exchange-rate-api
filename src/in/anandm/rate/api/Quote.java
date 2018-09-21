package in.anandm.rate.api;

public class Quote {

	private String currency;
	private float rate;
	
	public Quote(String currency, float rate) {
		super();
		this.currency = currency;
		this.rate = rate;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public float getRate() {
		return rate;
	}
	
}
