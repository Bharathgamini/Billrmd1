package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage{
	
	public ShoppingCart(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	WebElement shopcart;
	
	@FindBy(xpath = "//input[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath ="//a[@class='btn btn-primary']")
	WebElement checkoutbutton;
	
	
	public boolean isShoppingPageExists()
	{
		try
		{
		return (shopcart.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void quantityupdate(String num)
	{
		quantity.click();
		quantity.clear();
		quantity.sendKeys(num);
	}
	
	public void checkout()
	{
		checkoutbutton.click();
	}
}
