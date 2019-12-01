package group.ten.p2.interfaces;

import java.io.IOException;
import group.ten.p2.soap.*;

public class SoapServer implements ServerInterface {

    ReservationBooking booking;
    public SoapServer(){
        ReservationBookingImplService bookingService = new ReservationBookingImplService();
        booking = bookingService.getReservationBookingImplPort();
    }

    public String getFlights() throws IOException{
        return booking.getFlights();
    }

    public String getFlight(String flightNumber) throws IOException{
        return booking.getFlight(flightNumber);
    }

    public String getSeatsForFlight(String flightNumber) throws IOException{
        return booking.getSeats(flightNumber);
    }

    public String bookSeatForFlight(String flightNumber, String seatNumber, String userId, String userName, int userAge, String foodSelection) throws IOException {
        return booking.bookSeat(flightNumber, seatNumber, userId, userName, userAge, foodSelection);
    }
}
