package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationobject {
	public WebDriver driver;

	public AccountRegistrationobject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpwd;
	@FindBy(name = "agree")
	WebElement checkbox;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement button;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setfirstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void setlastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void setemail(String mail) {
		email.sendKeys(mail);
	}

	public void settelephn(String number) {
		telephone.sendKeys(number);
	}

	public void setpwd(String password) {
		pwd.sendKeys(password);
	}

	public void confirmpwd(String password) {
		confirmpwd.sendKeys(password);
	}

	public void clickcheckbox() {
		checkbox.click();
	}

	public void clickcontinue() {
		button.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
