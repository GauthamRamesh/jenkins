package com.crm.practice;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;
public class DemoRetryTest 
{
	//@Test(retryAnalyzer = com.crm.genericUtils.RetryImplClass.class)
	@Test
	public void check()
	{
		System.out.println("Executed check()");
		fail();
	}
	@Test
	public void finish()
	{
		System.out.println("Executed finish()");
	}
}
