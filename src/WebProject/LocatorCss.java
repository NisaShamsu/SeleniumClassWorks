package WebProject;

import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCss {
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
	}
	//@Test
	/*public void LocatorsPg()
	{
		driver.findElement(By.name("email")).sendKeys("abcd");
		driver.findElement(By.id("pass")).sendKeys("abcd123");
		driver.findElement(By.name("login")).click();
	}*/
}
