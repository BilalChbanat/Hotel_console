import java.util.Date;

public class Reservation extends Room {
//    private int id;
    private Room room;
    private String client;
    private Date check_in_date;
    private Date check_out_date;

    public Reservation(String roomName, int capacity, boolean available, Room room, String client, Date check_in_date, Date check_out_date) {
        super(roomName, capacity, available);
        this.room = room;
        this.client = client;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
