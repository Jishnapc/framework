package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.DashboardPage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1)
	public void testValidLogin()
	{
//		1. enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("Admin");
//		2. enter valid pw
		loginPage.setPassword("admin123");
//		3. click on login button
		loginPage.clickLoginButton();
//		4. home page should be displayed
		DashboardPage dashboardPage=new DashboardPage(driver);
		boolean result = dashboardPage.verifyDashBoardPageIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
