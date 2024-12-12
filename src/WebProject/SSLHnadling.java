package WebProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHnadling 
{
	public static void main(String[] args) 
	{
		//SSL (SECURED SOCKET LAYES CERTIFICATE ) handling
	    //eg of a page is expired.badssl.com  tying to access a page which is private

		//Setting chrome options
		
	ChromeOptions options=new ChromeOptions();
	options.setAcceptInsecureCerts(true);  //accepts SSL certufcates  then pass this options to the chrome driver
		
		
		
		WebDriver driver=new ChromeDriver(options);   //passing options to chrome driver
		driver.get("https://expired.badssl.com/");
        String act_title=driver.getTitle();	
        System.out.println("Title of page is  = "+act_title);   //Privacy error first running 
                                                                 //After setting chromeoptions we get actual title expied.badssl.com  
       //set chrome options to continue 
	}

}
