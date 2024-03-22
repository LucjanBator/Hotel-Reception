package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSaveRooms{
    @Test
    void testSaveRooms() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(103, "Suite", 200.0);
        hotelManager.checkIn(103, "Bob");

        hotelManager.saveRoomsToExcel("testSave.xlsx");

        // Możesz dodać dodatkowe asercje, jeśli chcesz sprawdzić więcej szczegółów
        assertEquals("Bob", hotelManager.getRoomGuestName(103));
    }
}
