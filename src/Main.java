import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println(
                "╔══════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                      ║\n" +
                "║                                   Hotel Reservation System                           ║\n" +
                "║                                                                                      ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════╝");
        int input;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("║\t1: Display all available rooms  ║");
            System.out.println("║\t2: Make a reservation\t\t\t║");
            System.out.println("║\t3: Update a reservation\t\t\t║");
            System.out.println("║\t4: Cancel a reservation \t\t║");
            System.out.println("║\t5: Exit\t\t\t\t\t\t\t║");
            System.out.print("\t Enter your choice: \t");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("all romms");
                    break;
                case 2:
                    System.out.println("create a reservation");
                    break;
                case 3:
                    System.out.println("update reservation");
                    break;
                case 4:
                    System.out.println("remove a reservation");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (input != 5);

        sc.close();


    }
}