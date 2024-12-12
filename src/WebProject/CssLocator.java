package WebProject;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocator 
{
	ChromeDriver driver=new ChromeDriver(); //ctrl+Shift+O
	@Before
	public void setUp()
	{
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

}
