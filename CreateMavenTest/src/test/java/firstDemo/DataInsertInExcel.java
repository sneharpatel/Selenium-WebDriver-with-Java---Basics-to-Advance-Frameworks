package firstDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataInsertInExcel {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis =  new FileInputStream("/Users/sneha/eclipse-workspace/CreateMavenTest/ExcelSheet/PracticeDataSheet.xlsx");
		 XSSFWorkbook wbo  =  new XSSFWorkbook(fis);
		 XSSFSheet wso = wbo.createSheet("TestData2");
		 Row r ;
		
		 r = wso.createRow(0);
		 r.createCell(0).setCellValue("admin");
		String value = r.createCell(0).getStringCellValue();
		System.out.println(value);
	
	
		try {
		FileOutputStream fo = new FileOutputStream ("/Users/sneha/eclipse-workspace/CreateMavenTest/ExcelSheet/PracticeDataSheet.xlsx");
		wbo.write(fo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}

}
