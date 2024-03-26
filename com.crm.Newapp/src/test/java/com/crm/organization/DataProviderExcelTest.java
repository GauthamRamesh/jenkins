package com.crm.organization;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class DataProviderExcelTest 
{
	// HARDCODED //
	@DataProvider
	public Object[][] excelData() throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Login_Sheet");
		int lastrow=sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
