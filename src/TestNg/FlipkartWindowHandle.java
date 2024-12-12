package TestNg;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class FlipkartWindowHandle 
{
	ChromeDriver driver;
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void LocatorsPg()
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}
	@Test(priority=2)
	public void titleVerfication()
	{
		String actualTitle = driver.getTitle();
		System.out.println("title="+actualTitle);
		String exp="Amazon.in : mobiles";
		if(actualTitle.equals(exp))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
	}
	@Test(priority=3)
	public void addphone()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent window title is  "+driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("window.scrollBy(0,350)", "");
				//js.executeScript("document.getElementByID(‘element id ’).click()";
				//driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();		
				driver.findElement(By.xpath("//*[@id=\"bylineInfo\"]")).click();
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
}