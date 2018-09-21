package in.anandm.rate.api.fixer;

import in.anandm.rate.api.ExchangeRateProvider;
import in.anandm.rate.api.QuoteManager;

public class FixerExchangeRateProvider implements ExchangeRateProvider {

	@Override
	public QuoteManager create() {
		return new FixerQuoteManager(System.getenv("fixerAccessKey"));
	}

}
