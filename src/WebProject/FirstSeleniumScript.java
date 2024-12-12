package WebProject;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumScript {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		//driver.get("https://www.gmail.com");
		//driver.close();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		driver.quit();
		//driver.close();
		String Expectedtitle="Facebook";
		//Method 1
			if(actualTitle==Expectedtitle)	
			{
				System.out.println("test pass");
			}
			else
				System.out.println("test fail");
			// Method 2
			if(Expectedtitle.equals(actualTitle))
				System.out.println("test pass");
			else
				System.out.println("test fail");
				
			
     }
}