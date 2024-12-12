package WebProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileUPD 
{
	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.foundit.in/upload");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
		Thread.sleep(3000);
		
		//1.Using Send keys method
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("D:\\intrw.txt");
		
		//Using Robot class	
		//driver.findElement(By.xpath("//input[@id='file-upload']")).click();
		
		ChromeDriver js =driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='file-upload']")));
		
		//1.copy the file path into Clip board Ctrl+C	
		
		StringSelection filepathSelection = new StringSelection("D:\\intrw.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
			
		//2.Ctrl+V		
		
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);    // For MAC USERS Robot.keyPress(KeyEvent.VK_META)
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);		
		
		//3.Click on Enter key/Return
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);	
		
	}

}