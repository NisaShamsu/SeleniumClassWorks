package WebProject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay 
{
	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void titleVerfication()
	{
		String actualTitle = driver.getTitle();
		System.out.println("title="+actualTitle);
		String exp="Electronics, Cars, Fashion, Collectibles & More | eBay";
		if(actualTitle.equals(exp))
			System.out.println("Test Pass Title same");
		else
			System.out.println("Test Fail Title Different");
		
		String source=driver.getPageSource();
		String sourceName="Shop by category";
		if(source.contains(sourceName))
			driver.findElement(By.id("gh-shop-a")).click();
		else
			System.out.println("Shop by category not present in page");
		driver.findElement(By.xpath("//a[@class='scnd'][normalize-space()='Art']")).click();
		driver.findElement(By.xpath("//*[@href='https://www.ebay.com/b/Art-NFTs/262051/bn_7117725294']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Your shopping cart']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Books",Keys.ENTER);	
	}
	
}

