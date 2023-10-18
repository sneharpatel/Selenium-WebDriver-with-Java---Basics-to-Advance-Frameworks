
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		// Identify testcase column by scanning the entire row
		//once column is identified then scan entire testcase column to identify purchase test case
		//After you grab purchase testcase row = pull all the data of that row and feed into test
		FileInputStream fis = new FileInputStream("/Users/sneha/CSV_files/RSAPracticeDataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for(int i=0; i<=sheets; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify testcase column by scanning the entire row
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next(); // get first row
				Iterator<Cell> ce =  firstRow.cellIterator(); // row is a collection of cell

				int k = 0;
				int column = 0;
				while(ce.hasNext()){
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")){
						column = k;
					}
					k++;
				}
				System.out.println(column);

				//once column is identified then scan entire testcase column to identify "purchase" test case
				while(rows.hasNext()){
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")){
						//After you grab purchase testcase row = pull all the data of that row and feed into test
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()){
							Cell c = cv.next();
							if(c.getCellType() == CellType.STRING){  // The plan is to rename getCellTypeEnum() back to getCellType() in POI 4.0
								a.add(c.getStringCellValue());
							}else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							 }
						}
					}
				}
			}
		}

		return a;
	}

	public static void main(String[] args) throws IOException {

	}

}
