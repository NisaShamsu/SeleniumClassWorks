package WebProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;

public class LocatorsWebElement 
{
	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		}
	@Test
	public void LocatorsPg()
	{
		driver.findElement(By.name("email")).sendKeys("abcd");
		driver.findElement(By.id("pass")).sendKeys("abcd123");
		driver.findElement(By.name("login")).click();
	}
}
