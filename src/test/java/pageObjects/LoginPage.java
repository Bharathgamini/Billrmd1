package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password'][1]")
	WebElement txtpass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement buttonlogin;
	
	
	
	public void clickemail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void clickpassword(String pass)
	{
		txtpass.sendKeys(pass);
	}
	
	public void clicklogin()
	{
		buttonlogin.click();
	}


}
