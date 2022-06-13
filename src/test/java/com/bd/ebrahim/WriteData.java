package com.bd.ebrahim;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Emp_Info");

		Object empdata[][] = { { "EmpId", "Name", "job" }, { 101, "Ebrahim", "SQA" }, { 102, "Hossain", "Tester" } };

		int rows = empdata.length;
		int cols = empdata[0].length;

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = empdata[r][c];

				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}
			}
		}

		String filePath = ".\\dataFiles\\employee.xlsx";
		FileOutputStream outputStram = new FileOutputStream(filePath);
		workbook.write(outputStram);
		outputStram.close();
		System.out.println("Successfully Write Data on Excel Sheet");
	}

}
