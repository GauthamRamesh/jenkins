package com.crm.organization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.genericUtils.ExcelUtils;
import com.crm.genericUtils.FileUtils;
import com.crm.genericUtils.JavaUtils;
import com.crm.genericUtils.WebDriverUtils;
import com.objectRepo.CreateOrganizationPage;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;

public class CreateOrganizationTest 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=null;
		// Create Object for all Utility Classes //
		FileUtils flib=new FileUtils();
		ExcelUtils elib=new ExcelUtils();
		JavaUtils jlib=new JavaUtils();
		WebDriverUtils wlib=new WebDriverUtils();

		// Get common data using Properties File //
		String BROWSER=flib.readDataFromPropertyFile("Browser");
		String URL=flib.readDataFromPropertyFile("URL");
		String USERNAME=flib.readDataFromPropertyFile("UserName");
		String PASSWORD=flib.readDataFromPropertyFile("Password");
		
		// Get Specific data using Excel File //
				String orgname=elib.readDataFromExcel("data", 0, 1)+jlib.getRandomNo();
				String website=elib.readDataFromExcel("data", 1, 1);
				String tickerSymbol=elib.readDataFromExcel("data", 2, 1);
				String phone=elib.readDataFromExcel("data", 3, 1);

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("---Invalid Browser---");
		}

		// Maximize window //
		wlib.maximizeWindow(driver);
		driver.get(URL);

		// Wait for Page Load //
		wlib.waitForPageLoad(driver, 20);
		
		// Login to VTiger Application //
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		// Click on Organization Link //
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
       
		// Create Organization and Enter Data //
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrganization();
		
		cop.enterDataToFields(orgname, website, tickerSymbol,phone);
		
		// Choose from the  Industry DropDown //
		cop.industryFieldDropDown(driver);
		
		// Save Details //
		cop.saveDetails();
		Thread.sleep(2000);
		
		// Sign Out from VTiger Application //
		hp.administratorImage(driver);
		
		// Close the Browser //
		driver.quit();
	}
}
