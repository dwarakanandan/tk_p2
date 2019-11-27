package group.ten.p2;

import java.net.URI;

import javax.xml.ws.Endpoint;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import group.ten.p2.soap.ReservationBookingService;

public class ServerMain {

	public static void main(String[] args) {
		// run SOAP server
		Endpoint.publish("http://localhost:8090/bookingservice", new ReservationBookingService());

		// run REST server
		ResourceConfig rc = new ResourceConfig().packages("rest");
		JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);
		System.out.println("Successfully started server");
	}

}