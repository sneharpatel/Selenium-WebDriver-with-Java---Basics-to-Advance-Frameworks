// video-209:: https://www.udemy.com/course/selenium-real-time-examplesinterview-questions/learn/lecture/33511040#questions

package dataDriver.excelDataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProvide {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider="driveTest")
    public void testCaseData(String greeting, String communication, String id){
        System.out.println(greeting + communication + id);
    }

    // multiple data sets to our tests
    // array public
    // 5 sets of data as 5 arrays from data provider to your tests
    // then your test will run for 5 times with 5 separate data sets (arrays)

    @DataProvider(name="driveTest")
    public Object[][] getTestData() throws IOException {
        //Object[][] data = {{"hello", "text", "1"},{"bye", "message", "12"},{"seeYou", "calls", "234"}};
        // Every row of Excel should be sent to 1 array
        FileInputStream  fis = new FileInputStream("/Users/sneha/CSV_files/RSAPracticeDataProviderSheet.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0; i<rowCount-1; i++){
            row = sheet.getRow(i+1);
            for(int j=0; j<colCount; j++){
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }

        return data;
    }
}
