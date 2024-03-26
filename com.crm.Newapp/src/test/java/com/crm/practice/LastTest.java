package com.crm.practice;
import org.testng.annotations.Test;
public class LastTest 
{
	@Test(groups = "RegressionSuite")
	public void checkIn()
	{
		System.out.println("----Checked in at Airport----");
	}
	@Test(groups = "RegressionSuite")
	public void travel()
	{
		System.out.println("----Journey Started----");
	}
}
