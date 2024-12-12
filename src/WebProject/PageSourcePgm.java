package WebProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSourcePgm {
ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.Google.com");
		driver.manage().window().maximize();
	}
	@Test
	public void pageSource()
	{
		String source=driver.getPageSource();
		String sourceName="Gmail";
		if(source.contains(sourceName))
		{
			System.out.println("Gmail is present");
		}
		else
		{
			System.out.println("Gmail is not present");
		}	
		String source1="Hacker";
		if(source.contains(source1))
		{
			System.out.println("hacker  is present");
		}
		else
		{
			System.out.println("hacker is not present");
		}	
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
