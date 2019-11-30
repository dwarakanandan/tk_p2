package group.ten.p2.interfaces;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RestServer implements ServerInterface{
    public static final String ORIGIN_DATE = "date";
    public static final String FILGHT_NUMBER = "flightId";
    public static final String DEPARTURE_AIRPORT = "departureAirport";
    public static final String DEPARTURE_TIME = "departureTime";
    public static final String ARRIVAL_AIRPORT = "arrivalAirport";
    public static final String ARRIVAL_TIME = "arrivalTime";
    public static final String SEAT_TYPE = "type";
    public static final String SEAT_UNIQUE_CODE = "uniqueCode";
    public static final String EXIT_ROW = "exitRow";

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

    public String getFlight(String flightNumber) throws IOException {
        HttpGet request = new HttpGet(baseURL + "/flight/" + flightNumber);

        try(CloseableHttpResponse response = httpClient.execute(request)){
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }

    public String getSeatsForFlight(String flightNumber) throws IOException {
        HttpGet request = new HttpGet(baseURL + "/flight/" + flightNumber + "/seats");

        try(CloseableHttpResponse response = httpClient.execute(request)){
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }
}
