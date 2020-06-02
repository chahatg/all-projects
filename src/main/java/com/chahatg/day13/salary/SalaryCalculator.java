package com.chahatg.day13.salary;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*3.) Create an application to perform salary calculation based on number of days,  
 * hours employee works, role of his job and basic pay and write it into an excel
 * sheet. 
*/
public class SalaryCalculator {
	public static HashMap<String, Double> jobPayRate = new HashMap<String, Double>();
	
	
	public static final Logger LOGGER = Logger.getLogger(SalaryCalculator.class.getName());
	public static void main(String[] args) throws IOException {
		jobPayRate.put("CEO", 392.0);
		jobPayRate.put("Director", 75.0);
		jobPayRate.put("Manager", 61.50);
		jobPayRate.put("Developer", 37.0);
		LOGGER.info("created hashmap");
		
		Scanner in = new Scanner(System.in);
		
		LOGGER.info("inside while");

		System.out.println("Enter name:  ");
		String name = in.nextLine();
		System.out.println("Enter job title. Choose from the following:- ");
		jobPayRate.forEach((title, pay)->{
			System.out.println(title);
		});
		String title = in.nextLine();
			
		System.out.println("Enter days worked: ");
		int days = in.nextInt();
			
		System.out.println("Enter hours worked in a day: ");
		int hours = in.nextInt();
			
		/*String[] colHeaders = {"name", "title","days","hours"};
		for(String header : colHeaders) {
			Row row = sheet.createRow(++rowCount);
			Cell cell = row.createCell(++colCount);
			cell.setCellValue((String) header);
		}
			
		try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Chahat\\eclipse-workspace\\spring_practice\\src\\main\\java\\salaries.xlsx")) {
			workbook.write(outputStream);
	    }*/
			
		System.out.println("Your earned salary for " + days + " days and " 
				+ hours + " is " + calculateSalary(title, days,hours));
			
		writeToExcel(name, title, days, hours);
}
		
		

	
	public static Double calculateSalary(String title, int days, int hours) {
		Double salary = 0.0;
		salary = jobPayRate.get(title)*days*hours;
		return salary;
	}
	
	public static void writeToExcel(String name, String title, int days, int hours) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("salarySheet");
		
		
		LOGGER.info("created workbook, sheet");

		Object[][] data = {
				{name, title, days, hours, calculateSalary(title, days, hours)},
		};
		int rowCount = 0;
		
		for(Object[] abook : data) {
			Row row = sheet.createRow(++rowCount);
			int colCount = 0;
			for(Object field: abook) {
				Cell cell = row.createCell(++colCount);
				if(field instanceof String)
					cell.setCellValue((String) field);
				else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Chahat\\eclipse-workspace\\spring_practice\\src\\main\\java\\salaries.xlsx")) {
            workbook.write(outputStream);
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}


