package WebProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
public class TtileVerification {
	ChromeDriver driver;	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
	}
	@Test
	public void titleVerfication()
	{
		String actualTitle = driver.getTitle();
		System.out.println("title="+actualTitle);
		String exp="Facebook";
		if(actualTitle.equals(exp))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
	}
	@After
	public void tearDown()
	{
		driver.close();
		
	}
}
