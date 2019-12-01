package group.ten.p2;

import com.sun.net.httpserver.HttpServer;
import group.ten.p2.airport.Flight;
import group.ten.p2.rest.ReservationBookingController;
import group.ten.p2.soap.ReservationBookingImpl;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.xml.ws.Endpoint;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ServerMain {

	private static HashMap<String, Flight> flights;
	public static void main(String[] args) {
		flights = new LinkedHashMap<String, Flight>();
		for(int i = 1; i <= 7; i++){
			add_flight(new Flight("UA102", "Boeing", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA103","Boeing", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA104","Boeing", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));

			add_flight(new Flight("UA105","Airbus", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA106","Airbus", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA107","Airbus", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));

			add_flight(new Flight("UA108","Embraer", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA109","Embraer", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));
			add_flight(new Flight("UA110","Embraer", LocalDate.of(2019, 12, i), Instant.now(), Instant.now(), "FRA", "LHR", 300, 200, 150));

		}

		// run SOAP server
		Endpoint.publish("http://localhost:8090/bookingservice", new ReservationBookingImpl());

		// run REST server
		ResourceConfig rc = new ResourceConfig(ReservationBookingController.class);
		HttpServer serv =  JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);
		System.out.println("Successfully started server");
	}

	public static void add_flight(Flight flight){
		flights.put(flight.getUniqueCode(), flight);
	}

	public static HashMap<String, Flight> getFlights(){
		return flights;
	}

}
