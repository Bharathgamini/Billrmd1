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
	
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[1]")
	WebElement Addtocart;
	
	@FindBy(xpath = "//button[@data-loading-text='Loading...']")
	WebElement gotocart;
	
	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement checkout;
	
	
	
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
	
	public void clickaddtocart()
	{
		Addtocart.click();
	}
	public void goingtocart()
	{
		gotocart.click();
	}
	public void checkoutorder()
	{
		checkout.click();
	}
}
