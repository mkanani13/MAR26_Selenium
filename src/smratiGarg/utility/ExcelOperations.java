package smratiGarg.utility;

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


    public static List<Map<String,String>> readExcel(String filePath, String sheetName) throws IOException {
            File file = new File(filePath);
//        xls (till 2007) / xlsx (after 2027)
            FileInputStream fileInputStream = new FileInputStream(file);

            Workbook xssFWorkbook = new XSSFWorkbook(fileInputStream); //if my excel has .xlsc format
//        Workbook workbook = new HSSFWorkbook(); //if my excel has .xls format

            Sheet sheet = xssFWorkbook.getSheet(sheetName); //"Sheet1"
            System.out.println("Last row num : " + (sheet.getLastRowNum() + 1));
            System.out.println("Last column num : " + (sheet.getRow(0).getLastCellNum()));


            int totalRow = sheet.getLastRowNum() + 1;
            int totalColumn = sheet.getRow(0).getLastCellNum();

// getting all the headers first and storing in headers list
            List<String> headers = new ArrayList<>();
            Row rowHeaders = sheet.getRow(0);
            for (Cell cell : rowHeaders) {
                headers.add(cell.getStringCellValue());
            }


            List<Map<String,String>> listOfTableValue = new ArrayList<>();

        for (int rowIndex = 1; rowIndex < totalRow; rowIndex++) {
            Row fullRow = sheet.getRow(rowIndex);
            Map<String, String> dataTable = new HashMap<>();
            for (int cellIndex = 0; cellIndex < totalColumn; cellIndex++) {
                Cell cell = fullRow.getCell(cellIndex);
                if (CellType.STRING == cell.getCellType()) {
                    dataTable.put(headers.get(cellIndex), cell.getStringCellValue());
                } else if (CellType.NUMERIC == cell.getCellType()) {
                    dataTable.put(headers.get(cellIndex), String.valueOf(cell.getNumericCellValue()));
                } else if (CellType.BOOLEAN == cell.getCellType()) {
                    dataTable.put(headers.get(cellIndex), String.valueOf(cell.getBooleanCellValue()));
                }
            }
            listOfTableValue.add(dataTable);
        }

//
//
//
//
//        for (int rowIndex = 0 ; rowIndex  < totalRow ; rowIndex ++){
//            Row fullRow = sheet.getRow(rowIndex);
//
//            for (int cellIndex = 0 ; cellIndex < totalColumn ; cellIndex ++){
//                System.out.println(" -> "+sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue());
//                Cell cell = fullRow.getCell(cellIndex);
//
//                if( CellType.STRING == cell.getCellType()){
////                    System.out.print("Cell type String : " + cell.getStringCellValue());
//                } else if (CellType.NUMERIC == cell.getCellType()){
////                    System.out.print("Cell type Nunmber : "+cell.getNumericCellValue());
//                }else if (CellType.BOOLEAN == cell.getCellType()){
////                    System.out.print("Cell type Boolean :"+cell.getBooleanCellValue());
//                }
//
//            }
//            System.out.println("");
//        }
//
//        //when interviewer ask
//        //for (int row )
//




    return listOfTableValue;
    }


    public static void main(String[] args) throws IOException {
        readExcel ("src/smratiGarg/testData/mar26-data-driven.xlsx","orderPlacement");
    }
}
