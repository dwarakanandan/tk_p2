package group.ten.p2.interfaces;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RestServer implements ServerInterface{
    String baseURL = "http://localhost:8080/bookingservice";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public RestServer(){
    }

    public String getFlights() throws IOException {

        HttpGet request = new HttpGet(baseURL + "/flights");

        try(CloseableHttpResponse response = httpClient.execute(request)){
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }
}
