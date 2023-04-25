package generic_utility.fetchdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.conf.PropertyKey;
/**
 * This class has all the generic methods related to excel operation
 * @author HP
 *
 */
public class ExcelOperations {

	private DataFormatter df;
	private Workbook wb;
/**
 * Initialization of ExcelOperator
 * @param filePath
 */
	public  ExcelOperations(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			df = new DataFormatter();
			wb = WorkbookFactory.create(fis);
			fis.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to createWorkBook
	 * @param filePath
	 */
@Deprecated
	public void createWorkBook(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			df = new DataFormatter();
			wb = WorkbookFactory.create(fis);
			fis.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * This method is used to extract multiple the data from the excel sheet
 * @param expTestScriptName
 * @param sheetName
 * @return
 */
	public Map<String, String> getExcelData(String expTestScriptName, String sheetName) {

		Map<String, String> data = new HashMap<String, String>();
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j)).trim();
					String value = df.formatCellValue(sheet.getRow(i + 1).getCell(j)).trim();
					data.put(key, value);
				}
				break;
			}
		}
		// System.out.println(data+data.get(key));
		return data;
	}
	/**
	 * 
	 * @param expTestScriptName
	 * @param sheetName
	 * @return
	 */
	public Map<String, String> getExcelData(String expTestScriptName, generic_utility.enums.PropertyKey sheetName) {
		String sn = sheetName.name();
		
		Map<String, String> data = new HashMap<String, String>();
		Sheet sheet = wb.getSheet(sn);
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j)).trim();
					String value = df.formatCellValue(sheet.getRow(i + 1).getCell(j)).trim();
					data.put(key, value);
				}
				break;
			}
		}
		// System.out.println(data+data.get(key));
		return data;
	}

	/**
 * This method is used to extract any single data from the excel sheet
 * @param expTestScriptName
 * @param expKey
 * @param titleslist
 * @return
 */
	public String getExcelData(String expTestScriptName, String expKey, generic_utility.enums.PropertyKey titleslist) {

		String sn = titleslist.name();
		
		Sheet sheet = wb.getSheet(sn);
		int rowCount = sheet.getLastRowNum();

		String value = "";
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expKey)) {
						value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		System.out.println(value);
		return value;
	}

	public String getExcelData(String expTestScriptName, String expKey, String sheetname) {

		Sheet sheet = wb.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();

		String value = "";
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expKey)) {
						value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
						break;
					}
				}
				break;
			}
		}
//		System.out.println(value);
		return value;
	}
	
public String[][] getExcelData(String sheetname) {

		
		Sheet sheet = wb.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();

		String[][] arr=new String[rowCount][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i <= rowCount; i++) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
				arr[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				
			} 
		}
		return arr;
	}

	

	public void closeWorkBook() throws IOException {
		wb.close();
	}

}