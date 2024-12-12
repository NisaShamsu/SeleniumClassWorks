package TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AssertPgmTask 
{	
	ChromeDriver driver;	
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();		
	}
	@Test
	public void login()
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("student");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password123");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	}
	public void checkURL()
	{
		String expurl="https://practicetestautomation.com/practice-test-login/";
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(expurl, currentUrl);
		System.out.println("Login success/Test pass");
	}
}
