package TestNg;
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
public class ExtendReportFB 
{
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	String baseUrl="https://www.facebook.com/";
	
	@BeforeTest
	public void extendReport()
	{
		reporter=new ExtentHtmlReporter("./Reports/fbNewreport.html");  //Specify path of report
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
	
	@Test(priority=2)
	public void titleVerfication()
	{
		test=extent.createTest("FB title verification");
		String actualTitle = driver.getTitle();
		//System.out.println("title="+actualTitle);
		String exp="facebook – log in or sign up";
	    Assert.assertEquals(exp, actualTitle);		
	}
	
	@Test(priority=1)
	public void fbLogoTest()
	{
		test=extent.createTest("FB logo verification");
		boolean status=driver.findElement(By.xpath("//img[@alt='Facebook']")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test(priority=1)  //dependsOnMethods = {"titleVerfication"})
	public void login()
	{
		test=extent.createTest("FB login verification");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("NisaShinil");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
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
		
		

