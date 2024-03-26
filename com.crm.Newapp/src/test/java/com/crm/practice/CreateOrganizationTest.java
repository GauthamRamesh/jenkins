package com.crm.practice;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.genericUtils.*;
import com.objectRepo.*;
public class CreateOrganizationTest extends BaseClass
		{
	@Test(dataProvider = "genericDP")
		public void getData(String OrgName, String web, String sym, String phone) throws IOException, InterruptedException
		{
			// Click on Organization Link //
			HomePage hp=new HomePage(driver);
			hp.clickOnOrgLink();
		
			// Create Organization and Enter Data //
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.createOrganization();
			cop.enterDataToFields(OrgName, web, sym, phone);
//			driver.findElement(By.name("accountname")).sendKeys(OrgName+jlib.getRandomNo());
//			driver.findElement(By.name("website")).sendKeys(web);
//			driver.findElement(By.name("tickersymbol")).sendKeys(sym);
//			driver.findElement(By.name("phone")).sendKeys(phone);
			Thread.sleep(1000);
			// Save Details //
			cop.saveDetails();
		}
		
		@DataProvider
		public Object[][] genericDP() throws Throwable
		{
			ExcelUtils elib=new ExcelUtils();
			Object[][] value=elib.dataProvider("Sheet1");
			return value;
		}
}
