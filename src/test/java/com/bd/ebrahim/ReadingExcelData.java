package com.bd.ebrahim;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcelData {

	@Test
	public void ReadExcelData() throws IOException {
		// Declare a variable 'filePath' with data type String to store the path of the
		// file.
		String excelFilePath = ".\\dataFiles\\Test.xlsx";

		// Create an object of the file class and pass the 'filePath' as a parameter to
		// open xlsx based data file
		File file = new File(excelFilePath);
		System.out.println(file.getAbsolutePath());

		// Create an object of the FileInputStream class and pass the reference variable
		FileInputStream inputStram = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStram);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		/*
		 * for (int r = 0; r < rows; r++) { XSSFRow row = sheet.getRow(r);
		 * 
		 * for (int c = 0; c < cols; c++) { XSSFCell cell = row.getCell(c); switch
		 * (cell.getCellType()) { case STRING:
		 * System.out.print(cell.getStringCellValue()); break; case NUMERIC:
		 * System.out.print(cell.getNumericCellValue()); break; case BOOLEAN:
		 * System.out.print(cell.getBooleanCellValue()); break; case ERROR:
		 * System.out.print(cell.getErrorCellString()); break; case FORMULA:
		 * System.out.print(cell.getCellFormula()); break; case BLANK:
		 * System.out.print(cell.getRawValue()); break; } System.out.print(" | "); }
		 * System.out.println(); }
		 */

		// ****************Iterator*******************

		Iterator iterator = sheet.iterator();

		while (iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();
			Iterator cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case ERROR:
					System.out.print(cell.getErrorCellString());
					break;
				case FORMULA:
					System.out.print(cell.getCellFormula());
					break;
				case BLANK:
					System.out.print(cell.getRawValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

}
