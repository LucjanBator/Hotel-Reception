package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class AddRoomTest{
    private HotelManager hotelManager;
    @BeforeEach
    void setUp() {
        hotelManager = new HotelManager();
        hotelManager.addRoom(101, "Single Room", 100.0);
        hotelManager.addRoom(102, "Double Room", 150.0);
    }

    @Test
    void testAddRoom() {
        hotelManager.addRoom(103, "Suite", 200.0);
        assertNull(hotelManager.getRoomGuestName(103));
    }
}
