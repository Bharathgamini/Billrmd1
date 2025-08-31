package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("Straring TC001 Registration");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on my account link");
		hp.clickregister();
		logger.info("Clicked on Register link");
		String password = randomeAlphaNumeric();
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		logger.info("Providing Registration details");
		ar.setFirstName(randomeString().toUpperCase());
		ar.setLastName(randomeString().toUpperCase());
		ar.setEmail(randomeString()+"@gmail.com");
		ar.setTelephone(randomeNumeric());
		ar.setPassword(password);
		ar.SetConfirm(password);
		ar.setPolicy();
		ar.clickContinue();
		
		logger.info("validating expected message");
		String confmsg = ar.getmsgconfirmation();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			AssertJUnit.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			AssertJUnit.assertFalse(true);
		}
		}
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
		logger.info("Finished Test case execution");
		}
	
}
