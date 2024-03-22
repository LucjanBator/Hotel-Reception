package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestCheckIn {
    @Test
    void testCheckIn() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(101, "Single Room", 100.0);

        hotelManager.checkIn(101, "John Doe");
        assertEquals("John Doe", hotelManager.getRoomGuestName(101));

        hotelManager.checkIn(101, "Jane Doe");
        assertNotEquals("Jane Doe", hotelManager.getRoomGuestName(101));
    }
}
