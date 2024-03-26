package com.crm.practice;
import static org.testng.Assert.fail;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.genericUtils.BaseClass;
//@Listeners(com.crm.genericUtils.ListImplClass.class)
public class DemoTest extends BaseClass
{
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
