package in.anandm.rate.api.fixer;

import java.net.MalformedURLException;
import java.time.LocalDate;

import com.google.gson.Gson;

public class FixerAPI {

	private static final Gson gson = new Gson();

	public static FixerRequest request(String accessKey, String base, LocalDate date) throws MalformedURLException {
		return new FixerRequest(gson, accessKey, base, date);
	}
}
