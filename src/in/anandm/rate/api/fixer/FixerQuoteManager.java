package in.anandm.rate.api.fixer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import in.anandm.rate.api.Quote;
import in.anandm.rate.api.QuoteManager;

public class FixerQuoteManager implements QuoteManager {
	

	private String accessKey;

	public FixerQuoteManager(String accessKey) {
		super();
		this.accessKey = accessKey;

	}

	@Override
	public List<Quote> getQuotes(String base, LocalDate date) {
		List<Quote> quotes = new ArrayList<>();
		
		try {
			FixerResponse response =  FixerAPI.request(accessKey, base, date).call();
			
			if(response.isSuccess()) {
				Float requestBaseRate = response.getRates().get(base);
				for (Entry<String, Float> entry : response.getRates().entrySet()) {
					//TODO: precision
					quotes.add(new Quote(entry.getKey(), entry.getValue() / requestBaseRate ));
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return quotes;
	}

	
}
