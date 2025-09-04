package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") // my account page heading
	WebElement msgheading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linklogout; // added in step6
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccountbtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	WebElement myaccountpage;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement accountlogout;
	
	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	WebElement editaccountdata;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return (msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void Clicklogout()
	{
		linklogout.click();
	}
	public void myaccountbutton()
	{
		myaccountbtn.click();
	}
	public void myaccountpageopen()
	{
		myaccountpage.click();
	}
	public void editaccount()
	{
		editaccountdata.click();
	}
	public void clicklogoutoption()
	{
		accountlogout.click();
	}
	

}
