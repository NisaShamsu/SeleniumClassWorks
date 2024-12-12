package WebProject;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		}
	@Test
	public void LocatorsPg()
	{
		driver.findElement(By.name("q")).sendKeys("Books",Keys.ENTER);
		//driver.findElement(By.name("btnK")).click();
	}
	
}
