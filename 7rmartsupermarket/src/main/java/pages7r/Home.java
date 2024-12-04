package pages7r;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	public WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@class='img-circle']")WebElement Admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreinfo;	
	
	public Home logout()
	{
		Admin.click();
		logout.click();
		return this;
	}
	public  AdminUsersAdd7r moreinfo()
	{
		//moreinfo.click(); doesnot work. So, javaScript executer is used.
		JavascriptExecutor javascript=(JavascriptExecutor)driver;
		javascript.executeScript("arguments[0].click();",moreinfo);
		
		return new AdminUsersAdd7r(driver);
	}
		
	
}
