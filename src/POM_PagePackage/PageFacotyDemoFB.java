package POM_PagePackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageFacotyDemoFB
{
		WebDriver driver;
		 @FindBy(id="email")
		 WebElement fbemail;
		 
		 @FindBy(id="pass")
		 WebElement passwrd;
		 
		 @FindBy(name="login")
		 WebElement fbloginbutton;
		 
		
		public PageFacotyDemoFB(WebDriver driver)   //Constructor same name as class name and pass driver details
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void setValues(String email,String password)
		{
			fbemail.sendKeys(email);
			passwrd.sendKeys(password);
		}
		public void login()
		{
			fbloginbutton.click();
		}	
}

