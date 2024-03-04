package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {

		static FileInputStream fileIn;
		static FileOutputStream fileOut;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;

		public static void healthDetails(String[] data, int row_num, String fileName, String sheetName) {
			try {
				fileIn = new FileInputStream(".\\excel_output\\" + fileName + ".xlsx");
			} catch (FileNotFoundException e) {
				fileIn = null;
			}

			if(fileIn == null) {
				workbook = new XSSFWorkbook();
			}
			else {
				try {
					workbook = new XSSFWorkbook(fileIn);
				} catch (IOException e) {
					System.out.println("Error creating worbook");
				}
			}
			try {
				sheet = workbook.createSheet(sheetName);
			}

			catch (Exception e) {
				sheet = workbook.getSheet(sheetName);
			}
			XSSFRow row0=sheet.createRow(0);
			row0.createCell(0).setCellValue("HEALTH INSURANCE DETAILS");
			XSSFRow row = sheet.createRow(row_num);
			for(int i = 0; i<data.length; i++) {
				row.createCell(i).setCellValue(data[i]);
			}

			if(fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					System.out.println("Error closing file " + fileName );
				}
			}
			try {
				fileOut = new FileOutputStream(".\\excel_output\\" + fileName + ".xlsx");
				workbook.write(fileOut);
				workbook.close();
				fileOut.close();
			} catch (IOException e) {
				System.out.println("Error writing file " + fileName + ".xlsx");
			}

		}
	
	
		public static void travelDetails(List<WebElement> plans, List<WebElement> amount) throws IOException
		{
			FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\excel_output\\travel.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			//sheet.createRow(t).createCell(0).setCellValue(data);
			HSSFRow row0 = sheet.createRow(0);
			row0.createCell(0).setCellValue("Company");
			row0.createCell(1).setCellValue("amount");
			for(int i=1; i<=3;i++) {
				HSSFRow row = sheet.createRow(i);
				row.createCell(0).setCellValue(plans.get(i-1).getText());
				row.createCell(1).setCellValue(amount.get(i-1).getText());
			}
			
			workbook.write(file);
			workbook.close();
			file.close();
		}

}
