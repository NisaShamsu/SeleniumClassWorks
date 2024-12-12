package TestNg;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AssertionPgm
{
		ChromeDriver driver;	
		@BeforeClass
		public void setUp()
		{
			driver=new ChromeDriver();
			driver.get("https://www.google.com");
			
		}
		@Test
		public void titleVerfication()
		{
			String actualTitle = driver.getTitle();
			System.out.println("title="+actualTitle);
			String exp="google";
		   // Assert.assertEquals(exp, actualTitle);
		   // System.out.println("Hello");  //Hard Assertion Lines of code doesnot execute if the test fail //hello willnot print
			if(actualTitle.equals(exp))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
			System.out.println("Soft assertion...runs the code even after the execution failed at a point"); // this will print
		}
	
}


