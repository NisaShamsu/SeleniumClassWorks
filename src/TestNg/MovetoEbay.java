package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MovetoEbay 
{
	ChromeDriver driver;
	@Test
	public void move()
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));  //Explicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit wait
		Actions act= new Actions(driver);
		WebElement electronics=driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
		act.moveToElement(electronics).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Smartphones and accessories']")));
		driver.findElement(By.xpath("//a[normalize-space()='Smartphones and accessories']")).click();
	    //driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[1]/a")).click();
		
	}
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");	
		driver.manage().window().maximize();
	}
}