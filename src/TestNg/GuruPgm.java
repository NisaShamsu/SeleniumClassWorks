package TestNg;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class GuruPgm
{
	ChromeDriver driver;	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");		
		driver.manage().window().maximize();
	}
	@Test
		public void alertHandle()
		{
		    Actions act=new Actions(driver);
		    
			act.contextClick(driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"))).perform();
			driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]")).click();
			Alert a=driver.switchTo().alert();
			String message=a.getText();
			System.out.println(message);
			a.accept();
			
			act.doubleClick(driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"))).perform();
			Alert b=driver.switchTo().alert();
			String msg=b.getText();
			System.out.println(msg);
			b.accept();
			
	   }
}
