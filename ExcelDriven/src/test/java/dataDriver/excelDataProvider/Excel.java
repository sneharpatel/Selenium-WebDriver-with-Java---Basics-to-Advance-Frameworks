package dataDriver.excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {

    @Test
    public void getExcel() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/sneha/CSV_files/RSAPracticeDataProviderSheet.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0; i<rowCount-1; i++){
            System.out.println("Outer loop started");
            row = sheet.getRow(i+1);
            for(int j=0; j<colCount; j++){
                System.out.println(row.getCell(j));
            }
            System.out.println("inner loop started");
        }




    }
}
