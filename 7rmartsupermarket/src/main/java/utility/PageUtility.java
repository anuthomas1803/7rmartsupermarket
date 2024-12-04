package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
public void selectByIndex(WebElement dropdown,int index)
{
	Select Selobj=new Select(dropdown);
	Selobj.selectByIndex(index);
	
}	
}

