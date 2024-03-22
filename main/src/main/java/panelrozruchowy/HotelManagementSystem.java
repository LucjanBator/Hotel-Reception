package panelrozruchowy;

import maparoommanager.HotelManager;

import java.util.Scanner;

/**
 * Główna klasa systemu zarządzania hotelem.
 */
public class HotelManagementSystem {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("Enter command (list, view, checkin, checkout, save, load, add, exit):");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "list":
                    hotelManager.listRooms();
                    break;
                case "view":
                    System.out.println("Enter room number:");
                    int roomNumberView = scanner.nextInt();
                    scanner.nextLine();
                    hotelManager.viewRoom(roomNumberView);
                    break;
                case "checkin":
                    System.out.println("Enter room number:");
                    int roomNumberCheckIn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter guest name:");
                    String guestName = scanner.nextLine();
                    hotelManager.checkIn(roomNumberCheckIn, guestName);
                    break;
                case "checkout":
                    System.out.println("Enter room number:");
                    int roomNumberCheckOut = scanner.nextInt();
                    scanner.nextLine();
                    hotelManager.checkOut(roomNumberCheckOut);
                    break;
                case "save":
                    System.out.println("Enter file name to save:");
                    String saveFileName = scanner.nextLine();
                    hotelManager.saveRoomsToExcel(saveFileName);
                    break;
                case "load":
                    System.out.println("Enter file name to load:");
                    String loadFileName = scanner.nextLine();
                    hotelManager.loadRoomsFromExcel(loadFileName);
                    break;
                case "add":
                    System.out.println("Enter room number:");
                    int roomNumberAdd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    hotelManager.addRoom(roomNumberAdd, description, price);
                    break;
                case "exit":
                    System.out.println("Exiting program");
                    exitRequested = true; // Ustawienie flagi na true, aby wyjść z pętli
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
