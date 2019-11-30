package group.ten.p2.interfaces;

import java.io.IOException;

public interface ServerInterface {
    
    public String getFlights() throws IOException;

    public String getFlight(String flightNumber) throws IOException;

    public String getSeatsForFlight(String flightNumber) throws IOException;

}
