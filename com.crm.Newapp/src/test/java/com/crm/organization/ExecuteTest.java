package com.crm.organization;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.genericUtils.*;
import com.objectRepo.CreateOrganizationPage;
import com.objectRepo.HomePage;

public class ExecuteTest extends BaseClass
{
	@Test(dataProvider = "genericDP")
	public void getData(String OrgName, String web, String sym, String phone) throws IOException
	{
		// Click on Organization Link //
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLink();

				// Create Organization and Enter Data //
				CreateOrganizationPage cop=new CreateOrganizationPage(driver);
				cop.createOrganization();
				
				driver.findElement(By.name("accountname")).sendKeys(OrgName+jlib.getRandomNo());
				driver.findElement(By.name("website")).sendKeys(web);
				driver.findElement(By.name("tickersymbol")).sendKeys(sym);
				driver.findElement(By.name("phone")).sendKeys(phone);
				
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
