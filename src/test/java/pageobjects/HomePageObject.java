package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	 public WebDriver driver;

	public  HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myacct;
	@FindBy(linkText= "Login")
	WebElement login;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;

	// Action Methods
	public void clickmyaccount() {
		myacct.click();
	}

	public void register() {
		register.click();
	}

	public void login() {
		login.click();
	}
}
