package com.selenium.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import com.automation.base.CustomException;

import selenium.Element;

/**
 * Excel Automation
 * 
 * @author rohitL Date: 25 June 2018
 */





public class ExportUtilities {

	public static String getCellFinalValue(int row, int cell, Sheet sh) {
		int celltype = sh.getRow(row).getCell(cell).getCellType();
		String CellValue = null;

		switch (celltype) {
		case 0:
			Double dou = sh.getRow(row).getCell(cell).getNumericCellValue();
			CellValue = dou.toString();

			break;

		case 1:
			CellValue = sh.getRow(row).getCell(cell).getStringCellValue();

			break;

		case 3:
			System.out.println("Cell is empty");

			break;

		default:
			break;
		}
		return CellValue;

	}

	public static void compareXlsxFile(String ExpectedFilePath, String ActualFilePath) throws  CustomException, IOException  {

		// Create an object of File class to open xlsx file
		File file1 = new File(ExpectedFilePath);
		File file2 = new File(ActualFilePath);

		// Create an object of FileInputStream class to read excel file
		FileInputStream fis1 = new FileInputStream(file1);
		FileInputStream fis2 = new FileInputStream(file2);

		// Created the object od
		Workbook wbExpected = new XSSFWorkbook(fis1);
		Workbook wbActual = new XSSFWorkbook(fis2);

		// Read sheet inside the workbook by its name
		Sheet shExpected = wbExpected.getSheetAt(0);
		Sheet shActual = wbActual.getSheetAt(0);

		// Find number of rows in excel file
		int rowCount = shExpected.getLastRowNum() - shExpected.getFirstRowNum();

		for (int i = 0; i <= rowCount; i++) {
		//	System.out.println(i);
		//	System.out.println(shExpected.getRow(0).getPhysicalNumberOfCells());
		//	System.out.println(shExpected.getRow(i).getFirstCellNum());

			int cellCount = shExpected.getRow(i).getLastCellNum() - shExpected.getRow(i).getFirstCellNum();

			for (int j = 0; j <= cellCount; j++) {
				if (null == shExpected.getRow(i) || null == shExpected.getRow(i).getCell(j)) {
					continue;
				}

				if (null == shActual.getRow(i) || null == shActual.getRow(i).getCell(j)) {
					continue;
				}

				// int celltype = shExpected.getRow(i).getCell(j).getCellType();
				String Excepted = getCellFinalValue(i, j, shExpected);
				String Actual = getCellFinalValue(i, j, shActual);
				if (!Excepted.equals(Actual)) {
					//System.out.println("Testcase FAIL Exported record is not matched Properly"); 
					//System.out.println("Expected result is '"+Excepted+"'.");
					//System.out.println("Actual result is '"+Actual+"'.");
					throw new CustomException("Expected result is '"+Excepted+"', Actual result is "+Actual+". Exported File doesn't matched with Actual file.");
					
					
				}

			}

		}

		
		System.out.println("Records are properly verified");
	}
	
	
	
	
	
	public static void csvToXLSX(String csvFile, String xlsxFile, String separator) {
        try {
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(separator);
                XSSFRow currentRow=sheet.createRow(RowNum);
                RowNum++;
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFile);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
          //  System.out.println("Conversion done");
         //  System.out.println("Output:" + xlsxFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	/*
	public static void CsvToXlsxConverter(String csvPath, String XlsxPath ) throws IOException {
		try {
			
			//String csvPath = "E://Table Tracker Expected.csv"; // csv file address
			//String XlsxPath = "E://test.xlsx"; // xlsx file address
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			String currentLine = null;
			int RowNum = 0;
			BufferedReader br = new BufferedReader(new FileReader(csvPath));
			while ((currentLine = br.readLine()) != null)
			{
				String str[] = currentLine.split(",");
				RowNum++;
				XSSFRow currentRow = sheet.createRow(RowNum);		
				
				for (int i = 0; i < str.length; i++)
				{
					currentRow.createCell(i).setCellValue(str[i]);
				}
			}

			FileOutputStream fileOutputStream = new FileOutputStream(XlsxPath);
			workBook.write(fileOutputStream);
			fileOutputStream.close();
			System.out.println("Done");
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "Exception in try");
		}
		*/
		
		
		
	//this method true if filename is present in downloadPath
	
	
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File file = new File(downloadPath);
		File[] filesList = file.listFiles();
		for (File f : filesList) {
			if (f.isFile() && f.getName().contains(fileName)) {

				return flag = true;
			}
		}

		return flag;

	}
	
	
// this method delete all files which contain filename in current directory	
	
	public static void deleteFile(String downloadPath, String fileName) {
		File file = new File(downloadPath);
		File[] filesList = file.listFiles();
		for (File f : filesList) {

			if (f.isFile() && f.getName().contains(fileName)) {
				// System.out.println(f.getName());
				f.delete();

			}
		}
	}
	
	
	
	
	public static void VerifyExportButton(String PathOfDownloadFolder, String contentOfFileName,List <WebElement> WebTableContent,Element elementOfExportButton ) throws CustomException, InterruptedException 
	{
		if(WebTableContent.size()>1)
		{
			ExportUtilities.deleteFile(PathOfDownloadFolder, contentOfFileName);
			elementOfExportButton.click();	
			for (int i=0;i<60;i++)
			{
				
				if(ExportUtilities.isFileDownloaded(PathOfDownloadFolder, contentOfFileName))
				{
					break;
				}
				else
				{
					Thread.sleep(5000);
				}		
				
			}

			if(ExportUtilities.isFileDownloaded(PathOfDownloadFolder, contentOfFileName))
			{
			//	System.out.println("Report is exported properly");
			}
			else
			{
				throw new CustomException("Report is not Exported");
				
			}
			
			
		}
		else
		{
			System.out.println("Current Report doesnot have data in last 7 days");
			
		}
		
		
	}
	
	
	public static String downloadFolderPath() throws CustomException, InterruptedException 
	{
		String	downloadDir= System.getProperty("user.home")+"\\Downloads";
			
		return downloadDir;

	}
	
	
	
	
	
	
	

}
