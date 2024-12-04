package pages7r;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class AdminUsersAdd7r {
	public WebDriver driver;

	public AdminUsersAdd7r(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	}



	@FindBy(xpath="//input[@id='username']") WebElement UsernameField;
	@FindBy(xpath="//input[@id='password']") WebElement PasswordField;
	@FindBy(xpath="//select[@name='user_type']") WebElement User_Typedropdwn;
	@FindBy(xpath="//button[@name='Create']") WebElement Save;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement AlertSaveSuccess;
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement AlertSaveFail;
	
    @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement Newbutton;
    public AdminUsersAdd7r createnew()
	{ 
    Newbutton.click();
    return  this;
   	}
	public AdminUsersAdd7r enter_username(String nameofuser)
	{
		UsernameField.sendKeys(nameofuser);	
		 return  this;
	}
	public AdminUsersAdd7r enter_password(String passwordofuser)
	{
		PasswordField.sendKeys(passwordofuser);	
		 return  this;
	}
	public AdminUsersAdd7r userType()
	{
		PageUtility page=new PageUtility();
		page.selectByIndex(User_Typedropdwn, 2);
		 return  this;
		//User_Typedropdwn.click();
		//Select Selobj=new Select(User_Typedropdwn);
		//Selobj.selectByValue("staff");
	}
	public AdminUsersAdd7r savedetails()
	{
		Save.click();
       return  this;
	}  
	public boolean isSavesuccess() //success alert window
	{
	return 	AlertSaveSuccess.isDisplayed();
	}
	
	}


