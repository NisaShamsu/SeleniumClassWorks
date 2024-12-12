package TestNg;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class FileUploadPgm 
{
	ChromeDriver driver;
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().window().maximize();
	}
	@Test
	public void fileUp() throws AWTException, InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		fileUpload("C:\\Users\\user\\Desktop\\RESUME_NISA.docx");
	}
	private void fileUpload(String p) throws AWTException, InterruptedException
	{
		StringSelection strSelection=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);	
	}	
}
