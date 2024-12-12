package WebProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDemo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js =driver;
		
			driver.get("https://www.pennyjuice.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
			//1....scroll down page by pixel number
			
			/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			js.executeScript("window.scrollBy(0,1500)", "");
			System.out.println(js.executeScript("return window.pageYOffset;")); */ //300
		
		
			
			//2....scroll page till element is visible
			
				/* WebElement e1=driver.findElement(By.xpath("//div[contains(text(),'Healthy Juice Concentrates for All Kids to Enjoy')]"));
				js.executeScript("arguments[0].scrollIntoView();",e1);
				System.out.println(js.executeScript("return window.pageYOffset;"));
				driver.findElement(By.xpath("//*[@id=\"1457658827\"]")).click();   */
		
		
			//3....Scroll page till end of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // if horizontal scroll bar we need to use Width
			System.out.println(js.executeScript("return window.pageYOffset;")); // we use XOffset instead of YOffset
			
			// Scrolling to initial position
		     Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

}
