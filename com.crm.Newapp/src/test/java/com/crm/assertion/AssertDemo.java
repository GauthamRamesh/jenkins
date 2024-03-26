package com.crm.assertion;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class AssertDemo 
{
	@Test
	public void hardAssert()
	{
		String exptitle="Online Shopping Site for Mobiles, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		System.out.println("Expected Title is "+exptitle);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		String actual=driver.getTitle();
		System.out.println("Actual Title is "+actual);
		assertEquals(actual, exptitle, "Actual not matching with");
	}
	
	@Test
	public void accessValue()
	{
		SoftAssert sa=new SoftAssert();
		int a=10;
		sa.assertNull(a);
		System.out.println(a);
		System.out.println("Access Value() is Executed");
	}
}
