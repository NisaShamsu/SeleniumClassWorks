package POMTest_Package;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import POM_PagePackage.PageFacotyDemoFB;
public class FbLoginTest
{
	public static WebDriver driver;
	
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void testLogin()
	{
		PageFacotyDemoFB ob=new PageFacotyDemoFB(driver);  // create object of classname
		ob.setValues("nisashinil@gmail.com", "abc123");
		ob.login();		
	}
}
