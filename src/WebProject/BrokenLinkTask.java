package WebProject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTask {
	ChromeDriver driver;	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://santamonicaedu.in/");
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
		verify(link);
	   }
	}
	public static void verify(String linkUrl)
    {
		int brokeCount=0;
		int successcount=0;
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
            	//System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            	brokeCount++;  	
            }  
            else
            {
            	successcount++;
                //System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            System.out.println("Number of broken link count = "+brokeCount);
           // System.out.println("Number of success links count= "+successcount);
        }catch (Exception e)
        {
        	System.out.println("Exception handled");
        }
   }	
}
