package TestNg;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandlePgm
{
	ChromeDriver driver;
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
	}
	@Test
	public void windowHandle()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent window title is  "+driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		
		Set<String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("nisa@gmail.com");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
}
