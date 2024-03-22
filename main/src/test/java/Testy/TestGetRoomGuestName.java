package Testy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import maparoommanager.HotelManager;

import static org.junit.jupiter.api.Assertions.*;

class TestGetRoomGuestName {
    private HotelManager hotelManager;
    @BeforeEach
    void setUp() {
        hotelManager = new HotelManager();
        hotelManager.addRoom(101, "Single Room", 100.0);
    }
    @Test
    void testGetRoomGuestName() {
        hotelManager.checkIn(101, "John Doe");
        assertEquals("John Doe", hotelManager.getRoomGuestName(101));
    }
}
