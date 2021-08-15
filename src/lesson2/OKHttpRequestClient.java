package lesson2;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OKHttpRequestClient {
	OkHttpClient client = new OkHttpClient();
	private static Log logger = LogFactory.getLog(OKHttpRequestClient.class);
	public static void main(String[] args) {
		OKHttpRequestClient client = new OKHttpRequestClient();
		try {
			client.run("http://localhost:8801");
		} catch (IOException e) {
			logger.error(e);
		}
	}
	private String run(String url) throws IOException {
		  Request request = new Request.Builder()
		      .url(url)
		      .build();

		  try (Response response = client.newCall(request).execute()) {
		    return response.body().string();
		  }
		}
}	
