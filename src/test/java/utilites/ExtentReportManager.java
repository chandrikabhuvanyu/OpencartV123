package utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener 
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test ;
	String repname;
	public void onStart(ITestContext testContext) 
	{
		/*SimpleDateFormat sd=new SimpleDateFormat();
		Date dt=new Date();
		String timeStramp =sd.format(dt);*/
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="Test-Report-"+timeStamp+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		
		sparkReporter.config().setDocumentTitle("OPencart Automaton Testing");
		sparkReporter.config().setReportName("Opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("application", "Opencart");
		extent.setSystemInfo("opratingsystem", System.getProperty("os.name"));
		extent.setSystemInfo("username", System.getProperty("user.name"));
		extent.setSystemInfo("Tester", "Chandrika");
		extent.setSystemInfo("Test environment", "QA");
			}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try {
		String Screenshotpath= System.getProperty("user.dir")+ "\\Screenshot\\"+result.getName() +".png";
		test.addScreenCaptureFromPath(Screenshotpath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
		/*try {
			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repname);
			
			 // Create the email message
			/* ImageHtmlEmail email = new ImageHtmlEmail();
			  email.setDataSourceResolver(new DataSourceUrlResolver(url));
			  email.setHostName("smtp.googlemail.com");
			  email.setSmtpPort(465);
			  email.setAuthenticator(new DefaultAuthenticator("chintamani.chandrika95@gmail.com", "password"));
			  email.setSSLOnConnect(true);
			  email.setFrom("pavanoltraining@gmail.com");   //Sender
			  email.setSubject("Test Results");
			  email.setMsg("Please find Attached Report....");
			  email.addTo("chandrikatcsmohan@gmail.com");   //Receiver
			  email.attach(url, "extent report", "please check report...");
			  email.send();   // send the email
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
	}
}
