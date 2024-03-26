package com.crm.practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.genericUtils.BaseClass;
import com.crm.genericUtils.ExcelUtils;
import com.objectRepo.CreateContactPage;
public class CreateContactTest extends BaseClass 
{
	@Test(dataProvider = "genericDP")
	public void createContacts(String firstname, String lastname, String orgname, String title, String department, String email, String assistant, String assistantphone) throws Throwable
	{
		String empDD = elib.readDataFromExcel("dd", 1, 0);
		// Click on Create Contact Link //
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.contactLink();
	
		// Enter Details in the Contact Information Page //
		ccp.enterContactDetails(firstname, lastname);

		// Window Actions //
		ccp.windowActionsForContPage(driver, orgname);
	
		// Lead Source Drop Down //
		ccp.leadDropDown(empDD);
	
		// Enter all Contact Fields //
		ccp.enterAllContactFields(title, department, email, assistant, assistantphone);
	
	ccp.save();
}
	@DataProvider
	public Object[][] genericDP() throws Throwable 
	{
		ExcelUtils eLib = new ExcelUtils();
		Object[][] value = eLib.dataProvider("dp");
		return value;
	}
}

