package maparoommanager;

import io.ExcelReader;
import io.ExcelWriter;

/**
 * Klasa zarządcy hotelu, która obsługuje operacje na pokojach.
 */
public class HotelManager {

    private MyMap<Integer, Room> rooms = new MyMap<>();
    static String s = "Invalid room number";
    /**
     * Wyświetla listę wszystkich pokoi w hotelu wraz z ich danymi.
     */
    public void listRooms() {
        System.out.println("Room list:");

        for (MyMap.MyEntry<Integer, Room> entry : rooms.entrySet()) {
            Room room = entry.value();
            System.out.print("Room " + room.getNumber() + ": " + room.getDescription());

            if (room.getGuestName() != null) {
                System.out.print(" - Guest: " + room.getGuestName());
            } else {
                System.out.print(" - Guest: Not checked in");
            }

            System.out.println(" - Price: " + room.getPrice());
        }
    }
    /**
     * Wyświetla dane o konkretnym pokoju w hotelu.
     *
     * @param roomNumber Numer pokoju do wyświetlenia.
     */
    public void viewRoom(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            System.out.println("Room " + room.getNumber() + ": " + room.getDescription());
            if (room.getGuestName() != null) {
                System.out.println("Guest: " + room.getGuestName());
            } else {
                System.out.println("Guest: Not checked in");
            }
            System.out.println("Price: " + room.getPrice());
        } else {
            System.out.println(s);
        }
    }
    /**
     * Przeprowadza proces zameldowania gościa do pokoju.
     *
     * @param roomNumber Numer pokoju, do którego gość ma być zameldowany.
     * @param guestName  Imię gościa.
     */
    public void checkIn(int roomNumber, String guestName) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            if (room.getGuestName() == null || room.getGuestName().isEmpty()){  // Sprawdzamy, czy pokój jest niezajęty
                room.checkIn(guestName);
                System.out.println("Check-in successful");
            } else {
                System.out.println("Room is already occupied");
            }
        } else {
            System.out.println(s);
        }
    }
    /**
     * Przeprowadza proces wymeldowania gościa z pokoju.
     *
     * @param roomNumber Numer pokoju, z którego gość ma być wymeldowany.
     */
    public void checkOut(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            if (room.getGuestName() != null) {
                room.checkOut();
                System.out.println("Check-out successful");
            } else {
                System.out.println("Room is not occupied");
            }
        } else {
            System.out.println(s);
        }
    }
    /**
     * Zapisuje dane o pokojach do pliku Excel.
     *
     * @param fileName Nazwa pliku Excel do zapisu.
     */
    public void saveRoomsToExcel(String fileName) {
        if (!fileName.endsWith(".xlsx")) {
            fileName += ".xlsx";
        }
        ExcelWriter.writeExcel(fileName, rooms);
        System.out.println("Data saved to file: " + fileName);
    }
    /**
     * Wczytuje dane o pokojach z pliku Excel.
     *
     * @param fileName Nazwa pliku Excel do wczytania.
     */
    public void loadRoomsFromExcel(String fileName) {
        if (!fileName.endsWith(".xlsx")) {
            fileName += ".xlsx";
        }
        rooms = ExcelReader.readExcel(fileName);
        System.out.println("Data loaded from file: " + fileName);
    }
    /**
     * Dodaje nowy pokój do hotelu.
     *
     * @param roomNumber Numer nowego pokoju.
     * @param description Opis nowego pokoju.
     * @param price Cena nowego pokoju.
     */
    public void addRoom(int roomNumber, String description, double price) {
        if (!rooms.containsKey(roomNumber)) {
            Room newRoom = new Room(roomNumber, description, price);
            rooms.put(roomNumber, newRoom);
            System.out.println("Room added successfully");
        } else {
            System.out.println("Room with the same number already exists");
        }
    }
    /**
     * Zwraca imię gościa w danym pokoju.
     *
     * @param roomNumber Numer pokoju.
     * @return Imię gościa w pokoju lub null, jeśli pokój nie istnieje.
     */
    public String getRoomGuestName(int roomNumber) {
        Room room = rooms.get(roomNumber);
        return (room != null) ? room.getGuestName() : null;
    }
}
