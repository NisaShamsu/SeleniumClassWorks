package TestNg;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver=new ChromeDriver();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Thread.sleep(3000);
		
		//1..
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		
		//2..Using explicit wait
		/*WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert=mywait.until(ExpectedConditions.alertIsPresent());
		alert.accept();*/

        //3. Using Javascript executer object		
		ChromeDriver js =driver;
		try
		{		
		js.executeScript("window.alert=function{};");   // without try catch it will throw an exception even if the program runs successfully 
		                                                 //by handling the error.       so we will put that in try catch
		}
		catch(Exception e)
		{
			
		}		
	}

}
