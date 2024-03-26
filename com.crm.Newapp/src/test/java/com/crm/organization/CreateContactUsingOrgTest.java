package com.crm.organization;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.genericUtils.ExcelUtils;
import com.crm.genericUtils.FileUtils;
import com.crm.genericUtils.JavaUtils;
import com.crm.genericUtils.WebDriverUtils;
public class CreateContactUsingOrgTest 
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

		// Contact Details //
		String firstname=elib.readDataFromExcel("Contacts", 0, 1);
		String lastname=elib.readDataFromExcel("Contacts", 1, 1);
		String leadsource=elib.readDataFromExcel("Contacts", 2, 1);
		String title=elib.readDataFromExcel("Contacts", 3, 1);
		String department=elib.readDataFromExcel("Contacts", 4, 1);
		String email=elib.readDataFromExcel("Contacts", 5, 1);
		String assistant=elib.readDataFromExcel("Contacts", 6, 1);
		String assistantphone=elib.readDataFromExcel("Contacts", 7, 1);


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

		// Login //
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on Organization Link //
		driver.findElement(By.linkText("Organizations")).click();

		// Click  on Create Organization Lookup Image //
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		// Enter all Text Fields //
		/*	HashMap<String,String> m=elib.readMultipleData("data", 0);
		for (Entry<String,String> s : m.entrySet())
		{
			if(s.getKey().equalsIgnoreCase("accountname"))
			{
				 driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+jlib.getRandomNo());
			}
			else
			{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}*/
		// Click on Save Button //
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		Thread.sleep(2000);

		// Create Organization Info Page //
		WebElement orgInfoElement=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));

		// Wait until Element to be Visible //
		wlib.waitUntilEleToBeVisible(driver, 20, orgInfoElement);

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(orgInfoElement));

		String actualorg=orgInfoElement.getText();
		if(actualorg.contains(orgname))
		{
			System.out.println("Organization Created Successfully");
		}
		else
		{
			System.out.println("Organization not Created");
		}

		// Click on Contacts //
		driver.findElement(By.linkText("Contacts")).click();

		// Click  on Create Contact Lookup Image //
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// Enter Details in the Contact Information Page //
		WebElement firstnamedropdown=driver.findElement(By.name("salutationtype"));
		wlib.handleDropDown(firstnamedropdown, "Mr.");
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		// Switch to Child Window //
		wlib.switchToWindow(driver, "Accounts&action");

		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();

		// Switch to Parent Window //
		wlib.switchToWindow(driver, "Contacts&action");

		WebElement leadele=driver.findElement(By.name("leadsource"));
		// Handle Drop down //
		wlib.handleDropDown(leadsource, leadele);

		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("department")).sendKeys(department);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("assistant")).sendKeys(assistant);
		driver.findElement(By.id("assistantphone")).sendKeys(assistantphone);

		// Click on Save Button //
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		Thread.sleep(2000);

		WebElement contInfoElement=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wait.until(ExpectedConditions.visibilityOf(contInfoElement));
		String actualcont=contInfoElement.getText();
		if(actualcont.contains(lastname))
		{
			System.out.println("Contacts Created Successfully");
		}
		else
		{
			System.out.println("Contacts not Created");
		}

		// SignOut //
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		WebElement signout=driver.findElement(By.linkText("Sign Out"));
		wlib.mouseHoverHandle(driver, signout);

		// Close the Browser //
		driver.quit();
	}
}
