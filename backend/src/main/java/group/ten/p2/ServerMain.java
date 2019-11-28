package group.ten.p2;

import com.sun.net.httpserver.HttpServer;
import group.ten.p2.rest.ReservationBookingController;
import group.ten.p2.soap.ReservationBookingService;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.xml.ws.Endpoint;
import java.net.URI;

public class ServerMain {

	public static void main(String[] args) {
		// run SOAP server
		Endpoint.publish("http://localhost:8090/bookingservice", new ReservationBookingService());

		// run REST server
		ResourceConfig rc = new ResourceConfig(ReservationBookingController.class);
		HttpServer serv =  JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);
		System.out.println("Successfully started server");
	}

}