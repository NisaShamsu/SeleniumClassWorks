package WebProject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class SantamonicaPgm 
{
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://santamonicaedu.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void titleVerfication()
	{
		String actualTitle = driver.getTitle();
		System.out.println("title="+actualTitle);
		String exp="Santamonica Study Abroad Pvt. Ltd. | Education Consultants";
		if(actualTitle.equals(exp))
			System.out.println("Test Pass Title same");
		else
			System.out.println("Test Fail Title Different");
		
		String source=driver.getPageSource();
		String sourceName="STUDY ABROAD";
		if(source.contains(sourceName))
		{
			driver.findElement(By.xpath("//*[@id=\"menu-item-567\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-53\"]/a")).click();
			driver.findElement(By.xpath("//*[@href='https://santamonicaedu.in/about-us/']")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-567\"]/a")).click();
			driver.findElement(By.xpath("//input[@name='cname']")).sendKeys("Nisa");
		}
		else
			System.out.println("STUDY ABROAD is not present in page");		
	}
}
