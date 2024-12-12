package POM_PagePackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class FbLogin
{
	WebDriver driver;
	By fbEmail=By.id("email");
	By fbPaswd=By.id("pass");
	By fbLoginButton=By.name("login");
	
	public FbLogin(WebDriver driver)   //Constructor same name as class name and pass driver details
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setValues(String email,String password)
	{
		driver.findElement(fbEmail).sendKeys(email);
		driver.findElement(fbPaswd).sendKeys(password);
	}
	public void login()
	{
		driver.findElement(fbLoginButton).click();
	}
	
}
