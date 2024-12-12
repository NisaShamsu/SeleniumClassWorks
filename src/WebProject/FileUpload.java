package WebProject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileUpload {

	public static void main(String[] args)
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//Single file upload intrw.txt
		
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\intrw.txt");
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("intrw.txt"))
		{
			System.out.println("file successfully uploaded");
		}
		else
		{
			System.out.println("Upload fail");
		}*/
				
		// Multiple file uploads
		
		String file1="D:\\intrw.txt";
		String file2="D:\\Usability Testing Whatsapp Test Scenarios.docx";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int noOfFilesUploaded= driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		// Validation 1 = number of files
		if(noOfFilesUploaded==2)
		{
			System.out.println("All files are uploaded");
		}
		else
		{
			System.out.println("Files are not uploade/incorrect file uploaded");
		}
		
		// validation 2 validate file names
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("intrw.txt")
		&&(driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Usability Testing Whatsapp Test Scenarios.docx")))
		{ 
			System.out.println("Files name matching");
		}
		else
			System.out.println("file names are not matching");

	}
	
}
