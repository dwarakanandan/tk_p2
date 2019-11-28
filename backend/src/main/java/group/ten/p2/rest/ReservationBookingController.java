package group.ten.p2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookingservice")
public class ReservationBookingController {

	@Path("/{example}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String example(@PathParam("example") String example) {
		System.out.println("Working???");
		return example + "!!!!";
	}

}
