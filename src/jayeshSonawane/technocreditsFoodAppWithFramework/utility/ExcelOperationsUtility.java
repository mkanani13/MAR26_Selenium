package jayeshSonawane.technocreditsFoodAppWithFramework.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperationsUtility {


    public static List<Map<String, String>> readExcel(String filePath, String sheetName) throws IOException {

        File file = new File(filePath);

        // Read the File
        FileInputStream fileInputStream = new FileInputStream(file);

        // Work with Excel Workbook
        Workbook xssfWorkbook = new XSSFWorkbook(fileInputStream); // Excel after 2007 (.xlsx)
//        Workbook sssfWorkbook = new SXSSFWorkbook(fileInputStream); // Excel before 2007 (.xls)

        Sheet sheet = xssfWorkbook.getSheet(sheetName);
//        System.out.println("Sheet Name: " + sheet);
        int totalRow = sheet.getLastRowNum();
        int totalColumn = sheet.getRow(0).getLastCellNum();

//        System.out.println("total totalRow: " + totalRow);
//        System.out.println("total col: " + totalColumn);

        // Store table Data in
        List<Map<String, String>> tableData = new ArrayList<>();

        // Get all headers (1st totalRow, Index 0) first and store in the list
        List<String> headers = new ArrayList<>();
        Row rowHeader = sheet.getRow(0);
        for(Cell cell : rowHeader) {
            headers.add(cell.getStringCellValue());
        }

        // Get all rows and store in map as kay value pair
        for(int rowNum = 1; rowNum <= totalRow; rowNum++) {
            // Get each row full data
            Row fullRow = sheet.getRow(rowNum);
            Map<String, String> rowColumnData = new HashMap<>();
            for (int colNum = 0; colNum < totalColumn; colNum++) {
                // get each column full data
                Cell cell = fullRow.getCell(colNum);
                if (cell.getCellType() == CellType.NUMERIC) {
                    rowColumnData.put(headers.get(colNum), String.valueOf((int)cell.getNumericCellValue()));
                } else if (cell.getCellType() == CellType.STRING) {
                    rowColumnData.put(headers.get(colNum), cell.getStringCellValue());
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    rowColumnData.put(headers.get(colNum), String.valueOf(cell.getBooleanCellValue()));
                }
            }
            tableData.add(rowColumnData);
        }

        return tableData;
    }

//    public static void main(String[] args) throws IOException {
//        List<Map<String, String>> tableData = new ArrayList<>();
//        tableData = readExcel("D:\\Work\\Automation Testing (Java+Selenium)\\Intelli_J\\MAR26_Selenium\\src\\jayeshSonawane\\technocreditsFoodAppWithFramework\\testData\\mar26-data-driven.xlsx","Sheet1");
//        System.out.println(tableData);
//        /*
//                 |<------------------------------------------------------------Column1---------------------------------------------------------------------------------------------------->|
//        Row 1 = [{restaurantname=Balance Brew Cafe, qnty=5, cashOnDelivery=true, locality=Baner, fooditem=Cold Brew Coffee, placeOrderAddress=Aundh, paymentMethod=UPI, mobileNo=8950714840},
//        Row 2 =  {restaurantname=Starbucks Cafe, qnty=6, cashOnDelivery=false, locality=Koregaon Park, fooditem=Fries, placeOrderAddress=Wakad, paymentMethod=Card, mobileNo=8976451230},
//        Row 3 =  {restaurantname=The Shahar, qnty=9, cashOnDelivery=true, locality=Hadapsar, fooditem=Alfredo pasta, placeOrderAddress=Hinjewadi, paymentMethod=Net, mobileNo=6451238970}    ]
//         */
//
//        /*
//        Excel Sheet → List
//        Each Excel Row → Map
//        Column Header → Map Key
//        Cell Value → Map Value
//         */
//
//        /*
//        List
//        │
//        ├── Map 1 (8 key-value pairs)
//        │      restaurantname  → Balance Brew Cafe
//        │      locality        → Baner
//        │      fooditem        → Cold Brew Coffee
//        │      qnty            → 5
//        │      paymentMethod   → UPI
//        │      cashOnDelivery  → true
//        │      mobileNo        → 8950714840
//        │      placeOrderAddress → Aundh
//        │
//        ├── Map 2 (8 key-value pairs)
//        │      restaurantname  → Starbucks Cafe
//        │      locality        → Koregaon Park
//        │      ...
//        │
//        └── Map 3 (8 key-value pairs)
//               restaurantname  → The Shahar
//               locality        → Hadapsar
//               ...
//         */
//    }
}
