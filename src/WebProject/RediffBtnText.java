package WebProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffBtnText
{
	ChromeDriver driver;
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
	}	
	@Test
	public void buttonText()
	{
		WebElement buttonText=driver.findElement(By.xpath("//*[contains(@name,'btnchkavail')]"));
		String buttonName=buttonText.getAttribute("value");
		if(buttonName.equals("Check availability"))
		{
			System.out.println("Test Pass");
			
		}else
		{
			System.out.println("Test Fail");
		}
	}
}
