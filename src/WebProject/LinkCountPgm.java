package WebProject;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCountPgm {
	
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void linkCount()
	{
		List<WebElement> linksDetails=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links  : "+linksDetails.size());
	   for(WebElement web : linksDetails)
	   {
		String link=web.getAttribute("href");
		String linkText=web.getText();
		System.out.println("links = "+link);
		System.out.println("Link Text = "+linkText);		
	   }
	   List<WebElement> images=driver.findElements(By.tagName("img"));
	   System.out.println("Total number of images  : "+images.size());
	}
	/*public void imagesCount()
	{
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("Total number of images  : "+images.size());
	}*/
}
