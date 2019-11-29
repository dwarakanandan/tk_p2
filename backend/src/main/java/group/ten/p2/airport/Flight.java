package group.ten.p2.airport;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;

public class Flight {

    private Airplane airplane;
    private LocalDate date;
    private Instant departureTime;
    private Instant arrivalTime;
    private String departureAirport;
    private String arrivalAirport;
    private String flightId;
    private int firstPrice;
    private int economyPlusPrice;
    private int economyPrice;

    public Flight(String flightId, String airplaneType, LocalDate date, Instant departureTime,
                  Instant arrivalTime, String departureAirport, String arrivalAirport,
                  int firstPrice, int economyPlusPrice, int economyPrice) {
        this.airplane = new Airplane(airplaneType);
        this.flightId = flightId;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.firstPrice = firstPrice;
        this.economyPlusPrice = economyPlusPrice;
        this.economyPrice = economyPrice;
    }


    public String getDate() {
        return date.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime.toString();
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime.toString();
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String depatureAirport) {
        this.departureAirport = depatureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    public int getEconomyPlusPrice() {
        return economyPlusPrice;
    }

    public void setEconomyPlusPrice(int economyPlusPrice) {
        this.economyPlusPrice = economyPlusPrice;
    }

    public int getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(int economyPrice) {
        this.economyPrice = economyPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public LinkedHashMap<String, Seat> seats(){
        return airplane.getSeats();
    }

    public Seat getSeat(String seatId){
        return airplane.getSeat(seatId);
    }

    public String getUniqueCode(){
        return this.flightId + "-" + this.date.toString();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "airplane=" + airplane +
                ", date=" + date +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", firstPrice=" + firstPrice +
                ", economyPlusPrice=" + economyPlusPrice +
                ", economyPrice=" + economyPrice +
                '}';
    }
}
