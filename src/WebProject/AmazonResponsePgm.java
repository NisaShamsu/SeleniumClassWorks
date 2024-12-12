package WebProject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonResponsePgm 
{ 
	ChromeDriver driver;	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
 
	@Test
	public void linkCount()
	{
		List<WebElement> linksDetails=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links  : "+linksDetails.size());
		
	   for(WebElement str : linksDetails)
	   {
		String link=str.getAttribute("href");
		String linkText=str.getText();
		System.out.println("Link text is "+linkText+"Link is  "+link);
		verify(link);
	   }
	}
	private void verify(String link)
	{
			try
			{
			    URL u = new URL(link);
				HttpURLConnection con=(HttpURLConnection)u.openConnection();
				int code=con.getResponseCode();
				System.out.println(code);
				if(code==200)
					System.out.println("Response code is 200 / successfull link ----- "+link);
				else if (code==404)
					System.out.println("Response code is 404/Page not found -------"+link);
				else
					System.out.println("Other Responce code ");
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Link"+e.getMessage());
				
			}
		}
		
	}


