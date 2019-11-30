package group.ten.p2.interfaces;

import java.io.IOException;

public class SoapServer implements ServerInterface {

    public String getFlights() throws IOException{
        return "";
    }

    public String getFlight(String flightNumber) throws IOException{
        return "";
    }

    public String getSeatsForFlight(String flightNumber) throws IOException{
        return "";
    }

    public String bookSeatForFlight(String flightNumber, String seatNumber) throws IOException {
        return "";
    }
}
