package group.ten.p2.soap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.ten.p2.ServerMain;
import group.ten.p2.airport.Flight;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;

@WebService(endpointInterface = "group.ten.p2.soap.ReservationBooking")
public class ReservationBookingImpl implements ReservationBooking {

	private String SERVER_TAG = "[SOAP_SERVER]: ";

	@WebMethod
	public String helloWorld(String name) {
		return "Hello " + name + "!";
	}

	@WebMethod
	public String getFlights() {
		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "getFlights() called by Client\n");

		try {
			return objectMapper.writeValueAsString(flights.values());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getFlight(String flightId) {
		ObjectMapper objectMapper = new ObjectMapper();

		HashMap<String, Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "getFlight(" + flightId+ ") called by Client\n");
		try {
			return objectMapper.writeValueAsString(flights.get(flightId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getSeats(String flightId) {
		ObjectMapper objectMapper = new ObjectMapper();

		HashMap<String, Flight> flights = ServerMain.getFlights();
		System.out.println(SERVER_TAG + "getSeats(" + flightId+ ") called by Client\n");
		try {
			return objectMapper.writeValueAsString(flights.get(flightId).seats().values());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String bookSeat(String flightId, String seatId, String userId, String userName, int userAge, String foodSelection) {
		HashMap<String, Flight> flights = ServerMain.getFlights();
		Flight flight = flights.get(flightId);
		if(flight == null){
			System.out.println(SERVER_TAG + " book(" + flightId+ ", " + seatId + ") FAILURE: flight does not exist\n");
			return "SUCCESS";
		}

		String result = flight.bookSeat(seatId, userId, userName, userAge, foodSelection);
		System.out.println(SERVER_TAG + " book(" + flightId+ ", " + seatId + ") " + result + "\n");
		return result;

	}

}
