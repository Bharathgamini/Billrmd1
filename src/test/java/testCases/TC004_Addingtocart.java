package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ShoppingCart;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_Addingtocart extends BaseClass{
	
	
	// adding item to the cart
	@Test(groups ={"Regression", "Sanity", "Master", "DataDriven"}, dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_Checkout(String email, String pwd, String exp)
	{
		logger.info(" Starting TC_004 checkout");
		
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
		
		lp.mainpage();
		
		hp.clickaddtocart();
		hp.goingtocart();
		Thread.sleep(2000);
		hp.checkoutorder();
		
		Thread.sleep(2000);
		
		ShoppingCart sc = new ShoppingCart(driver);
		boolean shoppingpage = sc.isShoppingPageExists();
		System.out.println("Shoppping cart page exists");
		
		MyAccountPage max = new MyAccountPage(driver);
		
			if(shoppingpage == true)
			{
				System.out.println(shoppingpage);
				System.out.println("shopping page");
				//sc.quantityupdate(p.getProperty("num"));
				//sc.quantityupdate(num);
				
				sc.checkout();
				max.myaccountbutton();
				max.myaccountpageopen();
				max.Clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("Finished Tc_004");
	
}
}
