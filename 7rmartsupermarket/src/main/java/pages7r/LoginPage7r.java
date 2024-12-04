package pages7r;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage7r {
	public WebDriver driver;
	
public LoginPage7r(WebDriver driver)
{
this.driver=driver;  
PageFactory.initElements(driver,this);

//classname.methodName
}
@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
@FindBy(xpath="//button[@type='submit']") WebElement signin;
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;  //("//button[text()='Show Message']")
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alert;
public LoginPage7r enter_usernamefield(String usernamefield)
{
username.sendKeys(usernamefield);
return this;
}

public LoginPage7r enter_passwordfield(String passwordfield)
{
	password.sendKeys(passwordfield);
	return this;
} 

public Home click_signinbuton() 
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(signin));
	signin.click(); 
	return new Home(driver);
}
public boolean isDashBoardLoaded()
{
	return dashboard.isDisplayed();
}
public boolean alert()
{
	return alert.isDisplayed();
}

}



