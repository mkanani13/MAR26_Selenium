package technocredits.technoapp.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperations {


    public static List<Map<String, String>> readExcel(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
//        xls(till 2007)/xlsx(after 2007)
        FileInputStream fileInputStream = new FileInputStream(file); //Responsible to read file, if file not found

        List<Map<String, String>> listOfTabelValues = new ArrayList<>();

        Workbook xssfWorkbook = new XSSFWorkbook(fileInputStream);//If my excel has .xlsx format
//        Workbook hssfWorkbook = new HSSFWorkbook();//If my excel has .xls format

        Sheet sheet = xssfWorkbook.getSheet(sheetName);
        System.out.println("Last Row Num : " + (sheet.getLastRowNum() + 1));
        System.out.println("Last Column Num : " + sheet.getRow(0).getLastCellNum());//Header -> 0

        int totalRow = (sheet.getLastRowNum() + 1);
        int totalColumn = sheet.getRow(0).getLastCellNum();

        //Getting All the Headers first & Store
        List<String> headers = new ArrayList<>();
        Row rowHeader = sheet.getRow(0);
        for (Cell cell : rowHeader) {
            headers.add(cell.getStringCellValue());
        }


        // Now we will begin with iterating data
        for (int rowIndex = 1; rowIndex < totalRow; rowIndex++) {
            Row fullRow = sheet.getRow(rowIndex);
            Map<String, String> dataTable = new HashMap<>();
            for (int cellIndex = 0; cellIndex < totalColumn; cellIndex++) {
                Cell cell = fullRow.getCell(cellIndex);
                if (cell.getCellType() == CellType.STRING)
                    dataTable.put(headers.get(cellIndex), cell.getStringCellValue());
                else if (cell.getCellType() == CellType.NUMERIC)
                    dataTable.put(headers.get(cellIndex), String.valueOf(cell.getNumericCellValue()));
                else if (cell.getCellType() == CellType.BOOLEAN)
                    dataTable.put(headers.get(cellIndex), String.valueOf(cell.getBooleanCellValue()));
            }
            listOfTabelValues.add(dataTable);
        }

        // When interviwer asked to write excel reading
//        for (int row = 0; row < totalRow; row++) {
//            for (int cell = 0; cell < totalColumn; cell++) {
//                System.out.print(sheet.getRow(row).getCell(cell).getStringCellValue() + "\t");
//            }
//            System.out.println();
//        }
        return listOfTabelValues;
    }

}
