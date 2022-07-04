package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePageObject;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilites.XLUtility;

public class TC_003_MyAccountDDt extends BaseClass {
	@Test(dataProvider = "Logindata")
	public void test_MyAccountDDt(String email, String password, String exp) throws IOException {
		try {
			logger.info("Starting TC_003_MyAccountDDt");
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

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickonlogout();
					Assert.assertTrue(true);
				}

			} else {
				logger.info("Test failed");

				Assert.assertTrue(false);
			}

			if (exp.equals("Invalid")) {
				if (targetpage == false) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickonlogout();
					Assert.assertTrue(false);
				}
			} else {
				logger.error("Login Failed ");
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		logger.info("Finished TC_003_MyAccountDDt");

	}

	@DataProvider(name = "Logindata")
	public String[][] getData() throws IOException {
		String path = ".//testData//opensource_Logindata.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("sheet");
		int totalcellcount = xlutil.getCellCount("sheet1", 1);
		String logindata[][] = new String[totalrows][totalcellcount];
		for (int i = 1; i <= totalrows; i++) {

			for (int j = 0; j < totalcellcount; j++) {
				logindata[i-1][j] = xlutil.getCellData("sheet1", i, j);
			}
		}
		return logindata;
	}
}
