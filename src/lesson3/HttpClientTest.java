package lesson3;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class HttpClientTest {

	public static CloseableHttpClient httpclient = HttpClients.createDefault();

    // GET ����
    public static String getAsString(String url) throws IOException, ParseException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("token","123" );
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity1 = response.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            response.close();
        }
    }

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8088";
        String text = HttpClientTest.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

    }
}
