package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationobject;
import pageobjects.HomePageObject;
import testbase.BaseClass;

public class AccountRegistration extends BaseClass {

	@Test(groups= {"Regression","master"})
	public void test_registor() {
		logger.info("Starting the AccountRegistration");
		try {
			logger.info("Launching the browser");
			driver.get(rb.getString("appUrl"));
			driver.manage().window().maximize();
			logger.info("Clicking on myaccount and register");
			HomePageObject hb = new HomePageObject(driver);
			hb.clickmyaccount();
			hb.register();
			logger.info("Submitting customer details");
			AccountRegistrationobject ab = new AccountRegistrationobject(driver);

			ab.setfirstname("kim");
			logger.info("Clicked on first name");
			ab.setlastname("nick");
			logger.info("Clicked on last name");
			ab.setemail(randomestring() + "@gmail.com");
			//ab.setemail("xyz");
			logger.info("Clicked on email");
			ab.settelephn("78965412");
			logger.info("Clicked on phn number");
			ab.setpwd("Password345");
			logger.info("Clicked on password");
			ab.confirmpwd("Password345");
			logger.info("Clicked on confirmpassword");
			ab.clickcheckbox();
			logger.info("Clicked on checkbox");
			ab.clickcontinue();
			logger.info("Clicked on continue");
			String confmsg = ab.getConfirmationMsg();
			logger.info("Validation Started");
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("test case passed");
			} else {

				logger.error("Test case failed");
				captureScreen(driver,"test_registor");
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			logger.fatal("Registration failed");
			Assert.fail();

		}
	}
}
