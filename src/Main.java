import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        Room r1 = new Room(100, 2, true);
        Room r2 = new Room(101, 3, false);
        Room r3 = new Room(102, 4, true);

//        Reservation resv1 = new Reservation(reservations.size() + 1,r1, "Bilal", LocalDate.of(2024, 12, 7), LocalDate.of(2024, 12, 20));
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        System.out.println(rooms.get(1).getAvailability());
        System.out.println(
                "╔════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                    ║\n" +
                "║                                 Hotel Reservation System                           ║\n" +
                "║                                                                                    ║\n" +
                "╚════════════════════════════════════════════════════════════════════════════════════╝");
        int input;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n║\t1: Display all rooms \t\t\t║");
            System.out.println("║\t2: Make a reservation\t\t\t║");
            System.out.println("║\t3: Update a reservation\t\t\t║");
            System.out.println("║\t4: Cancel a reservation \t\t║");
            System.out.println("║\t5: Exit\t\t\t\t\t\t\t║");
            System.out.print("\t Enter your choice: ");

            input = sc.nextInt();
            Scanner scanner = new Scanner(System.in);
            switch (input) {
                case 1:
                    System.out.println(" \n");
//                    System.out.println(reservations);

                    for (Room room : rooms) {
                        if (room.getAvailability()){
                            System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "Available");
                        }else {
                            System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "Not Available");
                        }
                    }
                    break;
                case 2:
                    System.out.println("══════════════════════════════ Making a reservation... ══════════════════════════════");
                    System.out.print("\t\t Enter the room number: ");
                    int roomNumber = sc.nextInt();

                    // search
                    Room selectedRoom = null;
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNumber) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom == null) {
                        System.out.println("Room not found.");
                        break;
                    }

                    if (!selectedRoom.getAvailability()) {
                        System.out.println("Room is not available.");
                        break;
                    }

                    System.out.print("\t\t Enter the client name: ");
                    String clientName = sc.next();

                    System.out.print("\t\t Enter the check-in date (YYYY-MM-DD): ");
                    LocalDate checkInDate = null;
                    try {
                        checkInDate = LocalDate.parse(sc.next());
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        break;
                    }

                    System.out.print("\t\t Enter the check-out date (YYYY-MM-DD): ");
                    LocalDate checkOutDate = null;
                    try {
                        checkOutDate = LocalDate.parse(sc.next());
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        break;
                    }

                    if (checkInDate.isAfter(checkOutDate)) {
                        System.out.println("Check-out date cannot be before check-in date.");
                        break;
                    }

                    // Create the reservation
                    Reservation newReservation = new Reservation(reservations.size() + 1,selectedRoom, clientName, checkInDate, checkOutDate);
                    reservations.add(newReservation);
                    selectedRoom.setAvailability(false);  // Mark the room as unavailable

                    System.out.println("Reservation made successfully for " + clientName + " in Room " + roomNumber);
                    break;
                case 3:
                    System.out.print("Enter the reservation ID to update: ");
                    int reservationId = sc.nextInt();
                    boolean found = false;

                    for (Reservation reservation : reservations) {
                        if (reservation.getId() == reservationId) {
                            found = true;

                            // Update client name
                            System.out.print("Enter new client name: ");
                            String newClientName = sc.next();
                            reservation.setClient(newClientName);

                            // Update check-in date
                            System.out.print("Enter new check-in date (YYYY-MM-DD): ");
                            LocalDate newCheckInDate = null;
                            try {
                                newCheckInDate = LocalDate.parse(sc.next());
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                break;
                            }

                            // Update check-out date
                            System.out.print("Enter new check-out date (YYYY-MM-DD): ");
                            LocalDate newCheckOutDate = null;
                            try {
                                newCheckOutDate = LocalDate.parse(sc.next());
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                break;
                            }

                            if (newCheckInDate.isAfter(newCheckOutDate)) {
                                System.out.println("Check-out date cannot be before check-in date.");
                                break;
                            }

                            reservation.setCheck_in_date(newCheckInDate);
                            reservation.setCheck_out_date(newCheckOutDate);

                            // Room update is not included as it may complicate the logic and require further checks.
                            System.out.println("Reservation updated successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Reservation with ID " + reservationId + " not found.");
                    }

                    break;

                case 4:
                    System.out.println("cancle a reservation");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("!!!! Invalid choice. Please enter a number between 1 and 5. !!!!");
            }

        } while (input != 5);

        sc.close();


    }
}