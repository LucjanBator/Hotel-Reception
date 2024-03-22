package Testy;

import maparoommanager.HotelManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    void testViewRoomValidRoom() {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(101, "Single Room", 100.0);
        hotelManager.checkIn(101, "John Doe");

        String input = "101\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotelManager.viewRoom(101);

        assertTrue(outContent.toString().contains("Room 101: Single Room"));
        assertTrue(outContent.toString().contains("Guest: John Doe"));
        assertTrue(outContent.toString().contains("Price: 100.0"));

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testViewRoomInvalidRoom() {
        HotelManager hotelManager = new HotelManager();
        String input = "105\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotelManager.viewRoom(105);

        assertTrue(outContent.toString().contains("Invalid room number"));

        System.setIn(System.in);
        System.setOut(System.out);
    }
}

