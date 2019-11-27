package group.ten.p2.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "bookingservice")
public class ReservationBookingService {

	@WebMethod
	public String helloWorld() {
		return "Hello World!";
	}

}
