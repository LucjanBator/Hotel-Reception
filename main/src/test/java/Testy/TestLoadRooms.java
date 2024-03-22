package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLoadRooms {
    @Test
    void testLoadRooms() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(103, "Suite", 200.0);
        hotelManager.checkIn(103, "Bob");

        hotelManager.saveRoomsToExcel("testLoad.xlsx");

        HotelManager loadedHotelManager = new HotelManager();
        loadedHotelManager.loadRoomsFromExcel("testLoad.xlsx");

        // Asercje dla wczytanych danych
        assertEquals("Bob", loadedHotelManager.getRoomGuestName(103));
    }
}
