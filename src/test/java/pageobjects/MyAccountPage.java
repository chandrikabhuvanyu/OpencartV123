package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	public WebDriver driver;
	public MyAccountPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement  logout;
	//action methods
	
	public void clickonlogout() {
		logout.click();
	}
}
