package WebProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException
	{
		    ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.pennyjuice.com/");
			
			Thread.sleep(3000);
			driver.manage().window().minimize();  
			
			Thread.sleep(3000);//To minimize
			driver.manage().window().maximize();   //To maximize
			Thread.sleep(3000);
			
			JavascriptExecutor js =driver;
			js.executeScript("document.body.style.zoom='50%'");  //set zoom level 50%
			Thread.sleep(3000);
			
			js.executeScript("document.body.style.zoom='80%'");  //set zoom level 80%
			Thread.sleep(3000);
	}
}
