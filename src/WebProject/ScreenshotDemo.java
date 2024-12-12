package WebProject;
import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotDemo
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
		public void screenshot() throws IOException
		{
			File c=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileHandler.copy(c, new File("./screenshot/screenshot.png"));
			FileHandler.copy(c, new File("D:\\Screenshot\\screenshot.png"));
			
			WebElement button=driver.findElement(By.xpath("/html/body/input[1]"));
			File buttonImg=button.getScreenshotAs(OutputType.FILE);		
			//FileHandler.copy(buttonImg, new File("./screenshot/screenshotbutton.png"));
			FileHandler.copy(buttonImg, new File("D:\\Screenshot\\screenshotbutton.png"));
			
			WebElement SubmitBtn=driver.findElement(By.xpath("/html/body/input[4]"));
			File btnSubmit=SubmitBtn.getScreenshotAs(OutputType.FILE);
			//FileHandler.copy(btnSubmit, new File("./screenshot/submitbutton.png"));
			FileHandler.copy(c, new File("D:\\Screenshot\\submitbutton.png"));
		}
}
