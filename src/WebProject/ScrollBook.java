package WebProject;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollBook 
{
	public static void main(String[] args) throws InterruptedException 
	{		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		//JavascriptExecutor js =driver;
				
		// A Little Princess
		// Failed using action class method
		//WebElement book=driver.findElement(By.xpath("//h3[normalize-space()='A Little Princess']"));
		//act.scrollToElement(book).perform();
			
	    //using javascript executer  also failed
		//WebElement book=driver.findElement(By.xpath("//h3[normalize-space()='A Little Princess']"));
		//js.executeScript("arguments[0].scrollIntoView();", book);
				
		//Logic
		boolean found=false;
		while(!found)  //if true
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));			
			for(WebElement book:books)
			{
				if (book.getText().equalsIgnoreCase("A Little Princess"))
				{
					System.out.println("Book found");
					found=true;
					break;
				}
			}
			//js.executeScript("window.scrollBy(0,documennt.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(5000);
		}		
		driver.quit();
	}
}
