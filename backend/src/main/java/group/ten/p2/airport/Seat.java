package group.ten.p2;

public class Seat {

    String type;
    int row;
    String letter;
    boolean exitRow;
    boolean available = true;

    public Seat(int row, String letter, String type, boolean exitRow){
        this.type = type;
        this.row = row;
        this.letter = letter;
        this.exitRow = exitRow;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public boolean isExitRow() {
        return exitRow;
    }

    public void setExitRow(boolean exitRow) {
        this.exitRow = exitRow;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUniqueCode(){
        return row + letter;
    }
}
