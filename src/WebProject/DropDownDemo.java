package WebProject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownDemo 
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
	public void dropDown()
	{
		//inspect each dropdown
		//store in seperate web element
		//create select class object for each dropdown reference
		// Select objSelect = new Select(); //obj.Select.selectByVisibleText(“text”);//oSelect.selectByValue(“text”);
		//06 AUG 1986
		//driver.findElement(By.xpath("//select[contains(@name, 'DOB_Day')]"));  //by contains() method

		Select objSelectDate = new Select(driver.findElement(By.xpath("//select[contains(@name, 'DOB_Day')]")));      //Date
		objSelectDate.selectByValue("06");
		
		Select objSelectMonth = new Select(driver.findElement(By.xpath("//select[contains(@name, 'DOB_Month')]")));   //Month
		objSelectMonth.selectByVisibleText("AUG");
			
		Select objSelectYear = new Select(driver.findElement(By.xpath("//select[contains(@name, 'DOB_Year')]")));     //Year 
		objSelectYear.selectByValue("1986");
		
		//Select objcity = new Select(driver.findElement(By.xpath("//*[contains(@name,'city')]")));     //City method 1
		//objcity.selectByValue("Surat");
		
		WebElement city=driver.findElement(By.xpath("//*[contains(@name,'city')]"));     //city method 2
		Select cityobj=new Select(city);
		cityobj.selectByValue("Agra");
		
		driver.findElement(By.xpath("//*[contains(@name,'name')]")).sendKeys("Nisa P Shamsu");
		driver.findElement(By.xpath("//*[contains(@name,'login')]")).sendKeys("nisashinil@gmail.com");
		driver.findElement(By.xpath("//*[contains(@name,'btnchkavail')]")).click();
		driver.findElement(By.xpath("//*[contains(@name,'passwd')]")).sendKeys("Abc12345678#");
		driver.findElement(By.xpath("//*[contains(@name,'confirm_passwd')]")).sendKeys("Abc12345678#");
		driver.findElement(By.xpath("//*[contains(@name,'altemail')]")).sendKeys("nisashamsu@gmail.com");
		driver.findElement(By.xpath("//*[contains(@name,'mobno')]")).sendKeys("8921847149");
	    driver.findElement(By.xpath("//input[@value='f']"));
	    //driver.findElement(By.xpath("//*[contains(@id,'Register')]")).click();
	   // driver.findElement(By.xpath("//*[contains(@name,'btnchkavaile')]"));
	    //driver.findElement(By.xpath("//*text()='Check availability']")).click();
	  //  boolean displaystatus=driver.findElement(By.xpath("input[text()='Check availability'")).isDisplayed();
	  //  System.out.println(displaystatus);
	 
	}
}
