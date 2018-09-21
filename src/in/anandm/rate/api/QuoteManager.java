package in.anandm.rate.api;

import java.time.LocalDate;
import java.util.List;

public interface QuoteManager {
	
	List<Quote> getQuotes(String base, LocalDate date);
}
