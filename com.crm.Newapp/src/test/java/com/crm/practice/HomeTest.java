package com.crm.practice;
import org.testng.annotations.Test;
import com.crm.genericUtils.*;
import com.objectRepo.HomePage;
public class HomeTest extends BaseClass
{
	@Test
	public void homePageTabs()
	{
		// Click on all the Tabs on Home Page of VTiger Application //
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		hp.clickOnContLink();
		hp.clickOnOpporLink();
		hp.clickOnProdtLink();
		hp.clickOnDocmtLink();
		hp.clickOnEmailLink();
		hp.clickOnTroubleTickLink();
		hp.clickOnDashBrdLink();
	}
}
