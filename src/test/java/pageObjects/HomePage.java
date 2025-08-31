package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
// calling the immedidate parent class constructor and using the driver using the super keyword.
	// superkeyword is used to call the immedidate parent class constructor.
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkregister;
	
	@FindBy(linkText = "Login")
	WebElement btnlogin;
	
	
	
	public void clickmyaccount()
	{
		lnkmyaccount.click();
	}
	public void clickregister()
	{
		lnkregister.click();
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}

}
