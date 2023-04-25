package fc_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class B {
public static void main(String[] args) throws IOException {
	DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\orgnewdata1.xlsx");

	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Macro1");
	int rowCount = sheet.getLastRowNum();//it gives index
//	short cellCount = sheet.getRow(1).getLastCellNum();//it gives count
//	System.out.println(cellCount);
	System.out.println(rowCount);
	
	for(int i=1;i<= rowCount; i++) {
		short cellCount = sheet.getRow(i).getLastCellNum();//it gives count
		System.out.println(cellCount);
		for(int j=0; j< cellCount;j++) {
			System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
		}
	}
//	Row row = sheet.getRow(2);
//	Cell cell = row.getCell(1);
//	String data = df.formatCellValue(cell);
//	System.out.println(data);
//	wb.close();
//	fis.close();

}
}
