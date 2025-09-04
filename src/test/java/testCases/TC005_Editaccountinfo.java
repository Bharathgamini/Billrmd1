package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountInfoPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC005_Editaccountinfo extends BaseClass
{
	
	
	@Test(groups ={"Regression", "Sanity", "Master", "DataDriven"}, dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_Checkout(String email, String pwd, String exp)
	{
		logger.info(" Starting TC_005 checkout");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		//login
		
		LoginPage lp = new LoginPage(driver);
		lp.clickemail(email);
		lp.clickpassword(pwd);
		lp.clicklogin();
		
		MyAccountPage max = new MyAccountPage(driver);
		max.myaccountbutton();
		max.myaccountpageopen();
		max.editaccount();
		
		AccountInfoPage aip = new AccountInfoPage(driver);
		aip.updateFirstname();
		aip.updatelastname();
		aip.updatetelephone();
		aip.savedata();
		
		max.Clicklogout();
		
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		logger.info("Finished TC_005");
	}
}
