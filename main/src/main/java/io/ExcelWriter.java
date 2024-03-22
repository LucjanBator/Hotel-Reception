package io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import maparoommanager.MyMap;
import maparoommanager.Room;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * Klasa narzędziowa do zapisywania danych z kolekcji obiektów Room do pliku Excel.
 */
public class ExcelWriter {
    private ExcelWriter(){}
    /**
     * Zapisuje dane z kolekcji obiektów Room do pliku Excel.
     *
     * @param fileName Nazwa pliku Excel do zapisu.
     * @param rooms    Kolekcja obiektów Room do zapisu.
     */
    public static void writeExcel(String fileName, MyMap<Integer, Room> rooms) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Rooms");

            // Nagłówek arkusza
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("RoomNumber");
            headerRow.createCell(1).setCellValue("Description");
            headerRow.createCell(2).setCellValue("Price");
            headerRow.createCell(3).setCellValue("GuestName");

            // Zapisanie danych pokoi do arkusza
            int rowNum = 1;
            for (MyMap.MyEntry<Integer, Room> entry : rooms.entrySet()) {
                Room room = entry.value();
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(room.getNumber());
                row.createCell(1).setCellValue(room.getDescription());
                row.createCell(2).setCellValue(room.getPrice());
                row.createCell(3).setCellValue(room.getGuestName());
            }

            // Utwórz ścieżkę do pliku w katalogu roboczym
            String filePath = new File( "C:/Users/lucja/IdeaProjects/Zadanie_1/main/src/main/resources/" + fileName).getAbsolutePath();

            // Zapisz do pliku
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("Excel file written successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
