package com.crm.organization;
import org.testng.annotations.Test;
public class Practice001_Test
{
		@Test(dependsOnMethods = "deleteTest")
		public void createTest()
		{
			System.out.println("----Create Test()----");
		}
		@Test(priority = -1, invocationCount = 1)
		public void editTest()
		{
			System.out.println("----Edit Test()----");
		}
		@Test
		public void deleteTest()
		{
			int[] a= {1,2,3,4,5,6,};
			System.out.println(a[5]);
			System.out.println("----Delete Test()----");
		}
}
