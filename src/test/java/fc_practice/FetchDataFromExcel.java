package fc_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String expTestScriptName="AddRestaurant";
//			String expKey = "orgName";
			
			DataFormatter df=new DataFormatter();
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\orgnewdata1.xlsx");

			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Sheet4");
			int rowCount = sheet.getLastRowNum();//it gives index
			Map<String, String> map=new HashedMap<String, String>();
			for(int i=1; i<= rowCount; i++) {
				String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
//				System.out.println(testScriptName);
				if(testScriptName.equalsIgnoreCase(expTestScriptName.trim())) {
					for(int j=1; j<sheet.getRow(i).getLastCellNum();j++) {
						String 	key = df.formatCellValue(sheet.getRow(i).getCell(j));
						String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						map.put(key, value);
						
						}
					break;
					}
					
				}
				
//			System.out.println(map);
System.out.println(map.get("Restaurant Name"));
System.out.println(map.get("Bussiness E-mail"));
System.out.println(map.get("Phone"));
System.out.println(map.get("Website URL"));
System.out.println(map.get("Open Hours"));
System.out.println(map.get("Open Days"));
System.out.println(map.get("Select Category"));
System.out.println(map.get("Restaurant Address"));
System.out.println(map.get("Close Hours"));
}
}