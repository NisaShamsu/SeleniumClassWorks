package TestNg;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TrivagoDate
{
	ChromeDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.trivago.in/");
	    driver.manage().window().maximize();
	}		
	@Test
	public void datePick()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[1]/fieldset/button[1]/span/span[2]/span[2]")).click();
		//driver.findElement(By.xpath("//button[@data-testid='search-form-calendar-checkin']//span[@class='lSFHMh Z_w6a6']")).click();
		datePickMethod("December 2025","16");	
	}	
	public void datePickMethod(String expmonth,String expdate)
	{
		while(true)
		{
			String month=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3")).getText();
	        //System.out.println("Month is"+month);
			 if(month.equalsIgnoreCase(expmonth))
			 {
				break;	
			 }
			else
			{
    		  driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]/span")).click();			
		    }
	    }
	   List<WebElement> date=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));  
	 	for(WebElement d:date)
		{
			String datetext=d.getText();
			if(datetext.equalsIgnoreCase(expdate))
			{
				d.click();			
				break;
			}
		}
	}		
}


