package fc_practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromXL {
public static void main(String[] args) throws IOException {
	DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\orgnewdata1.xlsx");

	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Organization");
	Row row = sheet.getRow(2);
	Cell cell = row.getCell(1);
	String data = df.formatCellValue(cell);
	System.out.println(data);
	wb.close();
	fis.close();
}
}
