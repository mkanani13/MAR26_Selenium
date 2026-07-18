package riteshMali.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelOperations {

    public static void main(String[] args) throws IOException {
        File file = new File("src/riteshMali/testData/march_26_dataDriven_Ritesh_M.xlsx");
        System.out.println(file.exists());
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        System.out.println("Number of sheets: " + workbook.getNumberOfSheets());
        if (sheet == null) {
            System.out.println("Sheet not found!");
            return;
        }

        System.out.println("Last Row Num : " + (sheet.getLastRowNum() + 1));
        System.out.println("Last Column Num: " + sheet.getRow(0).getLastCellNum());

        int totalRow = sheet.getLastRowNum() + 1;
        int totalColumn = sheet.getRow(0).getLastCellNum();

        for (int rowIndex = 0; rowIndex <= totalRow; rowIndex++) {
            Row fullRow = sheet.getRow(rowIndex);
            for (int cellIndex = 0; cellIndex <= totalColumn; cellIndex++) {
                Cell cell = fullRow.getCell(cellIndex);
                if (CellType.STRING == cell.getCellType()) {
                    System.out.println("Cell Type String : " + cell.getStringCellValue());
                } else if (CellType.NUMERIC == cell.getCellType()) {
                    System.out.println("Cell Type Numeric : " + cell.getStringCellValue());
                } else if (CellType.BOOLEAN == cell.getCellType()) {
                    System.out.println("Cell Type Numeric : " + cell.getStringCellValue());
                }
            }
            System.out.println();
        }

    }
}
