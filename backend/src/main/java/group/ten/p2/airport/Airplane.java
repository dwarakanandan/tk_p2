package group.ten.p2;

import java.util.LinkedHashMap;

public class Airplane {

    LinkedHashMap<String, Seat> seats;

    public Airplane(String type){
        seats = new LinkedHashMap<String, Seat>();
        switch(type){
            case "Boeing":
                addRow(1, "ABEF", "United First", false);
                addRow(2, "ABEF", "United First", false);
                addRow(3, "ABEF", "United First", false);
                addRow(4, "ABEF", "United First", false);
                addRow(5, "ABEF", "United First", false);

                addRow(7, "DEF", "Economy Plus", false);
                addRow(8, "ABCDEF", "Economy Plus", false);
                addRow(9, "ABCDEF", "Economy Plus", false);
                addRow(10, "ABCDEF", "Economy Plus", false);
                addRow(11, "ABCDEF", "Economy Plus", false);

                addRow(12, "ABC", "Economy Plus", false);
                addRow(12, "DEF", "Economy", false);

                addRow(14, "ABCDEF", "Economy", false);
                addRow(15, "ABCDEF", "Economy", false);

                addRow(20, "ABCDEF", "Economy Plus", true);
                addRow(21, "ABCDEF", "Economy Plus", true);

                addRow(22, "ABCDEF", "Economy", false);
                addRow(23, "ABCDEF", "Economy", false);
                addRow(24, "ABCDEF", "Economy", false);
                addRow(25, "ABCDEF", "Economy", false);
                addRow(26, "ABCDEF", "Economy", false);
                addRow(27, "ABCDEF", "Economy", false);
                addRow(28, "ABCDEF", "Economy", false);
                addRow(29, "ABCDEF", "Economy", false);
                addRow(30, "ABCDEF", "Economy", false);
                addRow(31, "ABCDEF", "Economy", false);
                addRow(32, "ABCDEF", "Economy", false);
                addRow(33, "ABCDEF", "Economy", false);
                addRow(34, "ABCDEF", "Economy", false);
                addRow(35, "ABCDEF", "Economy", false);
                addRow(36, "ABCDEF", "Economy", false);
                addRow(37, "ABCDEF", "Economy", false);
                addRow(38, "ABCDEF", "Economy", false);
                addRow(39, "ABCDEF", "Economy", false);
                break;
            case "Airbus":
                addRow(1, "ABEF", "United First", false);
                addRow(2, "ABEF", "United First", false);

                addRow(7, "ABCDEF", "Economy Plus", false);
                addRow(8, "ABCDEF", "Economy Plus", false);
                addRow(10, "ABCDEF", "Economy Plus", false);
                addRow(11, "ABCDEF", "Economy Plus", false);
                addRow(12, "ABCDEF", "Economy Plus", false);
                addRow(20, "ABCDEF", "Economy Plus", false);

                addRow(21, "ABCDEF", "Economy Plus", true);

                addRow(22, "ABCDEF", "Economy", false);
                addRow(23, "ABCDEF", "Economy", false);
                addRow(24, "ABCDEF", "Economy", false);
                addRow(25, "ABCDEF", "Economy", false);
                addRow(26, "ABCDEF", "Economy", false);
                addRow(27, "ABCDEF", "Economy", false);
                addRow(28, "ABCDEF", "Economy", false);
                addRow(29, "ABCDEF", "Economy", false);
                addRow(30, "ABCDEF", "Economy", false);
                addRow(31, "ABCDEF", "Economy", false);
                addRow(32, "ABCDEF", "Economy", false);
                addRow(33, "ABCDEF", "Economy", false);
                addRow(34, "ABCDEF", "Economy", false);
                addRow(35, "ABCDEF", "Economy", false);
                break;
            case "Embraer":
                addRow(1, "ACD", "United First", false);
                addRow(2, "ACD", "United First", false);

                addRow(7, "ABCD", "Economy Plus", false);
                addRow(8, "ABCD", "Economy Plus", false);
                addRow(9, "ABCD", "Economy Plus", false);
                addRow(10, "ABCD", "Economy Plus", false);

                addRow(11, "ABCD", "Economy", false);
                addRow(12, "ABCD", "Economy", false);
                addRow(15, "ABCD", "Economy", false);
                addRow(16, "ABCD", "Economy", false);
                addRow(17, "ABCD", "Economy", false);
                addRow(18, "ABCD", "Economy", false);
                addRow(19, "ABCD", "Economy", false);
                addRow(20, "ABCD", "Economy", false);
                addRow(21, "ABCD", "Economy", false);
                addRow(22, "ABCD", "Economy", false);
                addRow(23, "ABCD", "Economy", false);
                addRow(24, "ABCD", "Economy", false);
                break;
        }
    }

    public LinkedHashMap<String, Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(String seatId){
        return seats.get(seatId);
    }

    public void setSeats(LinkedHashMap<String, Seat> seats) {
        this.seats = seats;
    }

    public void addRow(int row, String seatLetters, String type, boolean exitRow){
        for(String letter: seatLetters.split("")){
            Seat newSeat = new Seat(row, letter, type, exitRow);
            seats.put(newSeat.getUniqueCode(), newSeat);
        }
    }


}
