package TestNg;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileAutoitPgm {

	ChromeDriver driver;
	@BeforeTest
	public void setUP()
	{
		driver=new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().window().maximize();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void fileUp() throws AWTException, InterruptedException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		Thread.sleep(6000);
		Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\AutoIt\\t2.exe");
		Thread.sleep(5000);
	}
}
