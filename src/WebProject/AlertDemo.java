package WebProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo 
{
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/user/Desktop/alert_example.html");
		driver.manage().window().maximize();
	}
	@Test
	public void alertHandle()
	{
		
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert a=driver.switchTo().alert();
		String message=a.getText();
		System.out.println(message);
		a.accept();
		//a.dismiss(); for cancellation of an alert
		driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("Nisa");
		driver.findElement(By.xpath("/html/body/input[3]")).sendKeys("Shamsu");
		//driver.findElement(By.xpath("/html/body/input[4]")).click();
	}
}
