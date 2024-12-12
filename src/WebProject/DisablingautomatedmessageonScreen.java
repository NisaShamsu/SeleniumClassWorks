package WebProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisablingautomatedmessageonScreen 
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver=new ChromeDriver(options);
//pass the options in web driver,then only the execution done without launching the browser .otherwise execution will done just by loading the browser
//Disabling chrome is automated by essage from the browser
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
		//driver.quit();
	}

}
