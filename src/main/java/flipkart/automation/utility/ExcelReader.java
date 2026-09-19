package flipkart.automation.utility;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.*;

public class ExcelReader {
    public static Map<String, String> getData(String filePath, String sheetName, int rowNumber) {
        Map<String, String> data = new HashMap<>();
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row targetRow = sheet.getRow(rowNumber);

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = targetRow.getCell(i).getStringCellValue();
                data.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
