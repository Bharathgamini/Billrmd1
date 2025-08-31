package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("Starting login test");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.clickemail(p.getProperty("email"));
		lp.clickpassword(p.getProperty("password"));
		lp.clicklogin();
		
		MyAccountPage ma =new MyAccountPage(driver);
		boolean targetpage = ma.isMyAccountPageExists();
		//Assert.assertEquals(targetpage, true, "Login failed");
		System.out.println(targetpage);
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished tc002 execution");
	}
}
