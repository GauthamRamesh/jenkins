package com.crm.practice;
import org.testng.annotations.Test;
public class BasicTest 
{
	@Test(groups = "SmokeSuite")
	public void bookTicket() 
	{
		System.out.println("----Ticket Booked Successfully----");
	}
	@Test(groups = "SmokeSuite")
	public void departure() 
	{
		System.out.println("----Departure on March17th----");
	}
}
