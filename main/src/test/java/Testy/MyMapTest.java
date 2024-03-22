package Testy;

import maparoommanager.MyMap;
import maparoommanager.MyMap.MyEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    private MyMap<Integer, String> myMap;

    @BeforeEach
    void setUp() {
        myMap = new MyMap<>();
    }

    @Test
    void testPutAndGet() {
        myMap.put(1, "One");
        myMap.put(2, "Two");

        assertEquals("One", myMap.get(1));
        assertEquals("Two", myMap.get(2));
        assertNull(myMap.get(3)); // Non-existing key should return null
    }

    @Test
    void testContainsKey() {
        myMap.put(1, "One");
        myMap.put(2, "Two");

        assertTrue(myMap.containsKey(1));
        assertTrue(myMap.containsKey(2));
        assertFalse(myMap.containsKey(3));
    }

    @Test
    void testEntrySet() {
        myMap.put(1, "One");
        myMap.put(2, "Two");

        var entrySet = myMap.entrySet();

        assertEquals(2, entrySet.size());
        assertTrue(entrySet.contains(new MyEntry<>(1, "One")));
        assertTrue(entrySet.contains(new MyEntry<>(2, "Two")));
        assertFalse(entrySet.contains(new MyEntry<>(3, "Three")));
    }
}
