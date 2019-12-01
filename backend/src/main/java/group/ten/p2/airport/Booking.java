package group.ten.p2.airport;

public class Booking {
    Seat seat;

    private String userId;
    private String userName;
    private int userAge;
    private String footSelection;

    public Booking(Seat seat, String userId, String userName, int userAge, String footSelection) {
        this.seat = seat;
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.footSelection = footSelection;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getFootSelection() {
        return footSelection;
    }

    public void setFootSelection(String footSelection) {
        this.footSelection = footSelection;
    }

}
