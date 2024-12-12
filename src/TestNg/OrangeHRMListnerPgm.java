package TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
                                       //1.Create xml file of java pgm ..create listners class tag..inside create listner after test suite give the packag.classname
@Listeners(TestNg.MyListnerPgm.class)  //2. methodwithout using xml file we can integrate listener class directly to our pgm
public class OrangeHRMListnerPgm  {
	WebDriver driver;
	
	@BeforeClass
	public void setUP() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed(); 
		Assert.assertEquals(status, true);
	}
	@Test(priority=2)
	public void testAppURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority=3, dependsOnMethods = {"testAppURL"})
	public void testHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
}
