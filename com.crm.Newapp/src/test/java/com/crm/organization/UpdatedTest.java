package com.crm.organization;
import org.testng.annotations.Test;

public class UpdatedTest 
{
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "storeData")
	public void test(String compname, String location)
	{
		System.out.println("--"+compname+"---"+location);
	}
}
