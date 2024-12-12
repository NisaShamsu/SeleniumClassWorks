package TestNg;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DataDrivenDemo 
{
	ChromeDriver driver;	
	@BeforeTest	
	public void setUp()
	{
		driver=new ChromeDriver();			
	}
	@Test
	public void login() throws IOException
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();	
		FileInputStream fi=new FileInputStream("C:\\Users\\user\\Desktop\\Book.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowCount=sh.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			String userName=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username  ="+userName);
			String passWord=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password is "+passWord);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(userName);
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(passWord);
			driver.findElement(By.name("login")).click();			
		}
	}
}
	

