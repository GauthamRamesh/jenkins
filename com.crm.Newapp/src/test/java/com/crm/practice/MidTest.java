package com.crm.practice;
import org.testng.annotations.Test;
public class MidTest 
{
	@Test(groups = "RegressionSuite")
	public void shopping() 
	{
		System.out.println("----Shopped for the Trip----");
	}
	@Test(groups = "RegressionSuite")
	public void packLuggage() 
	{
		System.out.println("----Packed Luggage----");
	}
}
