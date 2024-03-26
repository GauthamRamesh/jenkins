package com.crm.home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.genericUtils.*;
import com.objectRepo.*;

public class HomeTest 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=null;
		// Create Object for all Utility Classes //
		FileUtils flib=new FileUtils();
		WebDriverUtils wlib=new WebDriverUtils();

		// Get common data using Properties File //
		String BROWSER=flib.readDataFromPropertyFile("Browser");
		String URL=flib.readDataFromPropertyFile("URL");
		String USERNAME=flib.readDataFromPropertyFile("UserName");
		String PASSWORD=flib.readDataFromPropertyFile("Password");

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

		// Click on all the Tabs on Home Page of VTiger Application //
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		hp.clickOnContLink();
		hp.clickOnOpporLink();
		hp.clickOnProdtLink();
		hp.clickOnDocmtLink();
		hp.clickOnEmailLink();
		hp.clickOnTroubleTickLink();
		hp.clickOnDashBrdLink();
		hp.administratorImage(driver);

		// Close the Browser //
		driver.quit();
	}
}
