package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInfoPage extends BasePage{
	
	public AccountInfoPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lastname;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Telephone;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continue;
	
	
	public void updateFirstname()
	{
		Firstname.clear();
		Firstname.sendKeys("Bharath");
	}
	public void updatelastname()
	{
		Lastname.clear();
		Lastname.sendKeys("Gamini");
	}
	public void updatetelephone()
	{
		Telephone.clear();
		Telephone.sendKeys("9392755777");
	}
	public void savedata()
	{
		Continue.click();
	}
	
}
