package TestNg;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DatePicker 
{
	ChromeDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Datepicker.html");	
		driver.manage().window().maximize();
	}
	@Test
	public void datePick()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"datepicker1\"]")).click();
		datePickmethod("December 2024","25");	
	}
	public void datePickmethod(String expmonth,String expdate)
	{
		while(true)
		{
			String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
			System.out.println("Month"+month);
			if(month.equals(expmonth))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
				
			}
		}
		List<WebElement> date=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[7]
		for(WebElement d : date)
		{
			String datetext=d.getText();
			if(datetext.equals(expdate))
			{
				d.click();
				break;
			}
		}
		
	}	
}
