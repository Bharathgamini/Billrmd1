package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	// when data provider class in another package and another class then we need to provide the class name
	
	@Test(groups ={"Regression", "Sanity", "Master", "DataDriven"}, dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		logger.info("Starting TC_003 loginddt");
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		//login
		
		LoginPage lp = new LoginPage(driver);
		lp.clickemail(email);
		lp.clickpassword(pwd);
		lp.clicklogin();
		
		
		//MyAccount
		MyAccountPage mac= new MyAccountPage(driver);
		boolean targetpage = mac.isMyAccountPageExists();
		System.out.println("My account text is found");
		/*
		 * Data is valid - login success - testpass - logout
		 * 					login failed - test fail
		 * 
		 * Data is invalid - login success - test fail - logout
		 * 					login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				System.out.println("Clicking logout");
				mac.Clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			mac.Clicklogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finised Tc003 ddt");
		
		//http://192.168.1.40:4444
		//http://localhost:4444
	}

}
