package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePageObject;
import pageobjects.LoginPage;
import testbase.BaseClass;

public class TC_002_Login extends BaseClass {
	
@Test(groups={"sanity","master"})
	public void test_Login() {
		logger.info("Starting TC_002_Login ");
		try {
			driver.get(rb.getString("appUrl"));
			driver.manage().window().maximize();
			HomePageObject hb = new HomePageObject(driver);
			hb.clickmyaccount();
			logger.info("clicked on myaccount");
			hb.login();
			logger.info("Clicked on my Login option button");
			LoginPage lg = new LoginPage(driver);
			lg.sendmail(rb.getString("email"));
			logger.info("provided email");
			lg.sendpassword(rb.getString("password"));
			logger.info("Provided pwd");
			lg.clicklogin();
			logger.info("clicked on login");

			boolean targetpage = lg.printmsg();

			if (targetpage) {
				logger.info("Test Passed");
				Assert.assertTrue(true);
			} else {
				logger.info("Test failed");
				captureScreen(driver, "test_Login");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_002_Login ");
	}
	
}
