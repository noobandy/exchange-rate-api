import java.util.Iterator;
import java.util.ServiceLoader;

import in.anandm.rate.api.ExchangeRateProvider;
import in.anandm.rate.api.Quote;
import in.anandm.rate.api.QuoteManager;

public class RateMain {

	public static void main(String[] args) {
		ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);

		QuoteManager manager = null;
		Iterator<ExchangeRateProvider> iterator = loader.iterator();
		while (iterator.hasNext()) {
			manager = iterator.next().create();
			break;
		}

		if (manager == null) {
			System.out.println("Service not configured properly");
		} else {
			for (Quote quote : manager.getQuotes("USD", null)) {
				System.out.format("%s : %f\n", quote.getCurrency(), quote.getRate());
			}
		}
	}

}
