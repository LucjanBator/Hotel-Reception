package io;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import maparoommanager.MyMap;
import maparoommanager.Room;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Klasa narzędziowa do odczytywania danych z pliku Excel i konwertowania ich na kolekcję obiektów Room.
 */
public class ExcelReader {
    private ExcelReader(){}
    /**
     * Odczytuje dane z pliku Excel i zwraca kolekcję obiektów Room.
     *
     * @param fileName Nazwa pliku Excel do odczytu.
     * @return MyMap zawierający obiekty Room.
     */
    public static MyMap<Integer, Room> readExcel(String fileName) {
        MyMap<Integer, Room> rooms = new MyMap<>();

        String filePath = new File("C:/Users/lucja/IdeaProjects/Zadanie_1/main/src/main/resources/" + fileName).getAbsolutePath();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);

            // Pomijamy nagłówek arkusza
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int roomNumber = (int) row.getCell(0).getNumericCellValue();
                    String description = getStringCellValue(row.getCell(1));
                    double price = row.getCell(2).getNumericCellValue();
                    String guestName = getStringCellValue(row.getCell(3));

                    Room room = new Room(roomNumber, description, price);
                    room.checkIn(guestName);
                    rooms.put(roomNumber, room);
                }
            }

            System.out.println("Excel file read successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }
    /**
     * Metoda pomocnicza do pobierania wartości tekstowej z komórki, obsługująca puste komórki.
     *
     * @param cell Komórka, z której pobierana jest wartość tekstowa.
     * @return Wartość tekstowa komórki lub pusty ciąg znaków, jeśli komórka jest null lub nie jest typu tekstowego.
     */
    // Metoda pomocnicza do obsługi pustych komórek
    private static String getStringCellValue(Cell cell) {
        if (cell != null && cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        }
        return "";
    }
}
