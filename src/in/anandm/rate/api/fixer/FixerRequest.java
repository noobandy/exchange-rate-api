package in.anandm.rate.api.fixer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

public class FixerRequest {
	// free no base
	private static final String API_TEMPLATE = "http://data.fixer.io/api/${point}?access_key=${accessKey}&format=1";
	private Gson gson;
	private URL url;

	FixerRequest(Gson gson, String accessKey, String base, LocalDate date) throws MalformedURLException {
		super();
		url = apiURL(accessKey, base, date);
		this.gson = gson;
	}

	public FixerResponse call;

	private URL apiURL(String accessKey, String base, LocalDate date) throws MalformedURLException {
		String point;

		if (date == null) {
			point = "latest";
		} else {

			// point = YYYY-MM-DD
			point = DateTimeFormatter.ISO_DATE.format(date);
		}

		String url = API_TEMPLATE.replace("${point}", point).replace("${accessKey}", accessKey);

		return new URL(url);

	}

	public FixerResponse call() throws IOException {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			FixerResponse response = gson.fromJson(bufferedReader, FixerResponse.class);
			return response;
		} catch (IOException e) {
			throw e;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
