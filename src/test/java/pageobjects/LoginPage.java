package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// loactors

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement Myaccountmsg;

	// Action Methods

	public void sendmail(String email_id) {
		email.sendKeys(email_id);
	}

	public void sendpassword(String pwd_id) {
		pwd.sendKeys(pwd_id);
	}

	public void clicklogin( ) {
		login.click();
	}

	public boolean printmsg() {
		try {
			return Myaccountmsg.isDisplayed();
		} catch (Exception e) {
			return (false);
		}
	}
}
