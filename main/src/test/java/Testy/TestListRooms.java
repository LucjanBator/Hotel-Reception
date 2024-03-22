package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestListRooms {
    @Test
    void testListRooms() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(101, "Single Room", 100.0);
        hotelManager.addRoom(102, "Double Room", 150.0);
        hotelManager.addRoom(103, "Suite", 200.0);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotelManager.listRooms();

        System.setOut(System.out);

        String printedOutput = outContent.toString();
        assertTrue(printedOutput.contains("Room 101: Single Room - Guest: Not checked in - Price: 100.0"));
        assertTrue(printedOutput.contains("Room 102: Double Room - Guest: Not checked in - Price: 150.0"));
        assertTrue(printedOutput.contains("Room 103: Suite - Guest: Not checked in - Price: 200.0"));
    }
}
