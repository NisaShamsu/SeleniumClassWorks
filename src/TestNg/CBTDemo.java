package TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class CBTDemo
{ 
	WebDriver driver;
	@Parameters("browser")
	
	@BeforeTest
	public void setUP(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
	}
	@Test(priority=1)
	public void crossBrowser()
	{
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
	}
	@Test(priority=2)
	public void DragnDrop()					
    {		
		
        Actions act=new Actions(driver);			
        WebElement AmtFrom=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));	 
        WebElement AmtTo=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));	
        WebElement Banksrc=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement BankDest=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        act.dragAndDrop(AmtFrom,AmtTo);		
        act.dragAndDrop(Banksrc,BankDest);
        act.perform(); 
	}	

}
