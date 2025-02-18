package group.ten.p2.rest;

import group.ten.p2.airport.Flight;
import group.ten.p2.airport.Seat;
import group.ten.p2.ServerMain;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;

@Path("/bookingservice")
public class ReservationBookingController {

	private String SERVER_TAG = "[REST_SERVER]: ";

	@Path("/{example}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String example(@PathParam("example") String example) {
		System.out.println("Working???");
		return example + "!!!!";
	}

	@Path("/flights")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Flight> getFlights(){
		HashMap<String,Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "/flights called by Client\n");
		return flights.values();
	}

	@Path("/flight/{flightId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Flight getFlight(@PathParam("flightId") String flightId){
		HashMap<String, Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "/flights/" + flightId+ " called by Client\n");
		return flights.get(flightId);
	}

	@Path("/flight/{flightId}/seats")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Seat> getSeats(@PathParam("flightId") String flightId){
		HashMap<String, Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "/flights/" + flightId+ "/seats called by Client\n");
		return flights.get(flightId).seats().values();
	}

	@Path("/book")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String bookSeat(@QueryParam("flightId") String flightId,
						   @QueryParam("seatId") String seatId,
						   @QueryParam("userId") String userId,
						   @QueryParam("userName") String userName,
						   @QueryParam("userAge") int userAge,
						   @QueryParam("foodSelection") String foodSelection){
		HashMap<String, Flight> flights = ServerMain.getFlights();
		Flight flight = flights.get(flightId);
		if(flight == null){
			System.out.println(SERVER_TAG + "/book/" + flightId+ "/" + seatId + " FAILURE: flight does not exist\n");
			return "SUCCESS";
		}

		String result = flight.bookSeat(seatId, userId, userName, userAge, foodSelection);
		System.out.println(SERVER_TAG + "/book/" + flightId+ "/" + seatId + " " + result + "\n");
		return result;
	}

}

