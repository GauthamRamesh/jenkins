package com.crm.organization;
import org.testng.annotations.DataProvider;

public class DataProviderTest 
{
	@DataProvider
	public Object[][] storeData()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="TestYantra";
		obj[0][1]="Bangalore";
		
		obj[1][0]="IBM";
		obj[1][1]="Chennai";
		return obj;
	}
}
