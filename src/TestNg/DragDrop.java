package TestNg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DragDrop 
{
	ChromeDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");	
		driver.manage().window().maximize();
		}
	@Test		
    public void DragnDrop()					
    {		
		//Using Action class for drag and drop.		
        Actions act=new Actions(driver);	
        		
		//Element which needs to drag.    		
        WebElement AmtFrom=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));	 
         //Element on which need to drop.		
         WebElement AmtTo=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));	
         
         //Bank
        WebElement Banksrc=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement BankDest=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
         			
	     //Dragged and dropped.		
         act.dragAndDrop(AmtFrom,AmtTo);		
         act.dragAndDrop(Banksrc,BankDest);
         act.perform();
	}	
}
