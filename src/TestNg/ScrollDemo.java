package TestNg;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollDemo
{
	ChromeDriver driver;
	JavascriptExecutor js =(JavascriptExecutor)driver;
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=713930225169&hvpos=&hvnetw=g&hvrand=11795391927473994975&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007776&hvtargid=kwd-64107830&hydadcr=14452_2402225&gad_source=1");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=1)
	public void method1()
	{
		//1....scroll down page by pixel number
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js.executeScript("window.scrollBy(0,300)", "");
		//System.out.println(js.executeScript("return window.pageYoffset;"));  //300
	}
	
	@Test
	public void method2()
	{
		
		//2....scroll page till element is visible
			//WebElement e1=driver.findElement(By.xpath("//[contains(text()='Continue shopping for')]"));
			//js.executeScript("arguments[0].scrollIntoView();",e1);
			//e1.click();
			
			
			//3....Scroll page till end of the page
		//	js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // if horizontal scroll bar we need to use Width
			//System.out.println(js.executeScript("return window.pageYOffset;")); // we use XOffset instead of YOffset
	
	}
	


}
