package WebProject;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CaptureScreenshot
{	
	public static void main(String[] args)
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pennyjuice.com/");
		driver.manage().window().maximize();
	/*	
		//1. Capture Screenshot of full page
		TakesScreenshot ts=driver;    //get screenshotAs method is calling from takescreenshot interface (main diff btwn 1 and 2 method)
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);  //Capture the screen shot somewhere in memmory
		File targetfile=new File("D:\\ECLIPSE\\SeleniumProject\\Screenshot\\fullpage.png");  //Copying the screenshot to user defined destination
		sourcefile.renameTo(targetfile);  //copy sourcefile to target file
        //Create a folder screenshot in the project( Right click project create a folder)   
		//Right click the screenshot folder..go to properties will give you the path //copy theEntire path then give anyname \\fullpage.png
		//File targetfile=new File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");  another method the best method we can access dynamically from anywhere.
	*/	
		
	/*	
		//2.Specific area screenshot
		WebElement healthyJuice=driver.findElement(By.xpath("//div[@id='1910446702']"));  //get screenshotAs method is called from webElement (it is also an interface)
	    File sourcefile=healthyJuice.getScreenshotAs(OutputType.FILE);
	    File targetfile=new File(System.getProperty("user.dir")+"\\Screenshot\\section.png");
	    sourcefile.renameTo(targetfile);
	    driver.quit();
	    
	    */
		
		//3. Specific Web Element Screenshot
		//driver.findElement(By.xpath("//img[@id='1361115106']"));
		WebElement logoElement=driver.findElement(By.xpath("//img[@id='1361115106']"));
		File source=logoElement.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"\\Screenshot\\Element.png");
		source.renameTo(destination);
		driver.quit();		
	}

}
