package WebProject;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ReportOrange
	{
		WebDriver driver;
		ExtentHtmlReporter reporter;
		ExtentTest test;
		ExtentReports extent;
		String baseUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		@BeforeTest
		public void extendReport()
		{
			reporter=new ExtentHtmlReporter("./Reports/OrangeReportNew.html");  //Specify path of report
			reporter.config().setDocumentTitle("Automation Report");  //Title of report
			reporter.config().setReportName("Functional Testing");  //Name of report
			reporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(reporter);
			
			extent.setSystemInfo("Computer Name", "local Host");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester Name", "Nisa");
			extent.setSystemInfo("OS", "Windows 11");
			extent.setSystemInfo("Browser name", "Chrome");
			
			driver=new ChromeDriver();		
		}
		@BeforeMethod
		public void beforMtd()
		{
			driver.get(baseUrl);
		}
		@Test(priority=1)
		public void testLogo()
		{
			test=extent.createTest("OrangeHRM logo verification");
			boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(status, true);
		}
		@Test(priority=2)
		public void testAppURL()
		{
			test=extent.createTest("URL verification");
			//Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/"); //fail so test 3 will skip as we put dependency on test 2
			Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //pass so test 3 also pass coz of dependency
			
		}
		@Test(priority=3, dependsOnMethods = {"testLogo"})  //{"testAppURL"} //tyy with this as well
		public void testHomePageTitle()
		{
			test=extent.createTest("OrangeHRM title verification");
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
		@AfterTest
		public void teardown()
		{
			extent.flush();
		}
		
		@AfterMethod
		public void browserClose(ITestResult result) throws IOException
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "Test Case Failed is  "+result.getName());
				test.log(Status.FAIL, "Test Case Failed is  "+result.getThrowable());
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				test.log(Status.SKIP, "Test Case Skipped is  "+result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "Test Case Passed is  "+result.getName());			
			}
		}  
	}


