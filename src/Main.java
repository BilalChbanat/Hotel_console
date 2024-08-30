import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        Room r1 = new Room("Room 101", 2, true);
        Room r2 = new Room("Room 102", 3, false);
        Room r3 = new Room("Room 103", 4, true);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        System.out.println(rooms.get(1).getAvailability());

    }
}