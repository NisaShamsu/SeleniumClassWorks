package WebProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeadlessTesting 
{
	public static void main(String[] args)
	{
		/* Normal application run
		WebDriver driver=new ChromeDriver();      //For Chrome browser
		//WebDriver driver=new EdgeDriver();          //For Edge browser
		//WebDriver driver=new FirefoxDriver();       //For Firefox browser
		//ChromiumDriver driver=new ChromeDriver();   //For Chrome browser
		
		//2) open url https://demo.opencart.com/
		driver.get("https://demo.opencart.com/");
		
		//3)Validate title should be "Your Store"
		String act_title=driver.getTitle();
		
		if(act_title.equalsIgnoreCase("Your Store"))
		{ 
			System.out.println("Test Pass");
			
		}
		else
		{
			System.out.println("Test fail");
		}
		driver.quit();
		*/
		
		//HEADLESS MODE achieved only using chrome options class
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");  //setting for headless ode of execution
		
		WebDriver driver=new ChromeDriver(options); //pass the options in web driver,then only the execution done without launching the browser .otherwise execution will done just by loading the browser
		driver.get("https://demo.opencart.com/");
        String act_title=driver.getTitle();	
		if(act_title.equalsIgnoreCase("Your Store"))
		{ 
			System.out.println("Test Pass");
			
		}
		else
		{
			System.out.println("Test fail");
		}
		driver.quit();
		

		//Advantages of headless mode testing
		//1.We can do multiple tasks(since execution is at the backend)
		//2. Faster execution
		
		//Disadvantages
		//1.user cannot see the actions on page.so he cannot understand flow/funtionality of test
		
		//SSL (SECURED SOCKET LAYES CERTIFICATE ) handling
		//eg of a page is expired.badssl.com
		
	}

}
