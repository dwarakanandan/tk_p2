package group.ten.p2.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ReservationBooking {

    @WebMethod
    String helloWorld(String name);

    @WebMethod
    String getFlights();

    @WebMethod
    String getFlight(String flightId);

    @WebMethod
    String getSeats(String flightId);

    @WebMethod
    String bookSeat(String flightId, String seatId, String userId, String userName, int userAge, String foodSelection);
}
