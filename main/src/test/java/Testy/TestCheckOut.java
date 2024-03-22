package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class TestCheckOut{
    @Test
    void testCheckOut() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(102, "Double Room", 150.0);

        hotelManager.checkIn(102, "Alice");
        hotelManager.checkOut(102);
        assertNull(hotelManager.getRoomGuestName(102));

        hotelManager.checkOut(102);
        assertNull(hotelManager.getRoomGuestName(102));
    }
}
