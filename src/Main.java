import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        Map<Integer, Reservation> reservations = new HashMap<>();
        Room r1 = new Room(100, 2, true);
        Room r2 = new Room(101, 1, false);
        Room r3 = new Room(102, 2, true);
        Room r4 = new Room(103, 3, true);
        Room r5 = new Room(104, 1, true);
        Room r6 = new Room(105, 2, false);
        Room r7 = new Room(106, 3, true);

        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);

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
            System.out.println("║\t2: Display all reservations \t║");
            System.out.println("║\t3: Make a reservation\t\t\t║");
            System.out.println("║\t4: Update a reservation\t\t\t║");
            System.out.println("║\t5: Cancel a reservation \t\t║");
            System.out.println("║\t6: Exit\t\t\t\t\t\t\t║");
            System.out.print("\t Enter your choice: ");

            input = sc.nextInt();
            Scanner scanner = new Scanner(System.in);
            switch (input) {
                case 1:
                    System.out.println(" \n");

                    for (Room room : rooms) {
                        if (room.getAvailability()){
                            System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "Available");
                        }else {
                            System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "Not Available");
                        }
                    }
                    break;
                case 2:
                    System.out.println(" \n");
                    if (reservations.isEmpty()) {
                        System.out.println(" \t There is no reservations");
                    }else{
                    for (Reservation reservation : reservations.values()) {

                            Room room = reservation.getRoom();
                            if (room.getAvailability()){
                                System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "Not reserved");
                            }else {
                                System.out.println(room.getRoomNumber() + "\t" + room.getCapacity() + "\t" + "reserved");
                            }


                    }
                    }
                    break;
                case 3:
                    System.out.println("══════════════════════════════ Making a reservation... ══════════════════════════════");
                    System.out.print("\t\t Enter the room number: ");
                    int roomNumber = sc.nextInt();


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
                        System.out.println("Invalid date format. YYYY-MM-DD format.");
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

                    int newReservationId = reservations.size() + 1;
                    Reservation newReservation = new Reservation(newReservationId, selectedRoom, clientName, checkInDate, checkOutDate);
                    reservations.put(newReservationId, newReservation);
                    selectedRoom.setAvailability(false);

                    System.out.println("Reservation made successfully for " + clientName + " in Room " + roomNumber);
                    break;
                case 4:
                    System.out.print("Enter the reservation ID to update: ");
                    int reservationId = sc.nextInt();
                    Reservation reservationToUpdate = reservations.get(reservationId);

                    if (reservationToUpdate != null) {
                        System.out.print("Enter new client name: ");
                        String newClientName = sc.next();
                        reservationToUpdate.setClient(newClientName);

                        System.out.print("Enter new check-in date (YYYY-MM-DD): ");
                        LocalDate newCheckInDate = null;
                        try {
                            newCheckInDate = LocalDate.parse(sc.next());
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                            break;
                        }

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

                        reservationToUpdate.setCheck_in_date(newCheckInDate);
                        reservationToUpdate.setCheck_out_date(newCheckOutDate);

                        System.out.println("Reservation updated successfully.");
                    } else {
                        System.out.println("Reservation with ID " + reservationId + " not found.");
                    }

                    break;
                case 5:
                    System.out.print("Enter the reservation ID to cancel: ");
                    int cancelReservationId = sc.nextInt();
                    Reservation reservationToCancel = reservations.get(cancelReservationId);

                    if (reservationToCancel != null) {
                        Room reservedRoom = reservationToCancel.getRoom();
                        reservedRoom.setAvailability(true);

                        reservations.remove(cancelReservationId);

                        System.out.println("Reservation with ID " + cancelReservationId + " has been successfully canceled.");
                    } else {
                        System.out.println("Reservation with ID " + cancelReservationId + " not found.");
                    }

                    break;

                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("!!!! Invalid choice. Please enter a number between 1 and 5. !!!!");
            }

        } while (input != 6);

        sc.close();
    }
}
