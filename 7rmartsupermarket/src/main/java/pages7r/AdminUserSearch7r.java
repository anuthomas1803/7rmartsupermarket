package pages7r;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserSearch7r {
	public WebDriver driver;
	String username;
	public AdminUserSearch7r(WebDriver driver,String username)
	{
		this.driver=driver;
		this.username=username;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement Searchoption;
@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']") WebElement SearchButton;
@FindBy(xpath="//input[@id='un']")WebElement searchUsernamefield;
@FindBy(xpath="//select[@id='ut']") WebElement Searchusertypedropdown;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") WebElement searchDetailsTable;
@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']") WebElement resultnotfound;
///html/body/div/div[1]/section/div/div/div[1]/div/a
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") List<WebElement> searchcolumn;
public void searchoption()
{
	Searchoption.click();
	
}
public void usernameSearch(String username)
{
	searchUsernamefield.sendKeys(username);
}
public void usertypeSearch(String indexinstring)
{
	 
     int indexnum = Integer.parseInt(indexinstring);  
	Select selusertype= new Select(Searchusertypedropdown);
	selusertype.selectByIndex(indexnum);   
}
public void searchuser()
{
	SearchButton.click();
}

public void Search_ParticularElements()
{
for(WebElement element: searchcolumn)
{
if(element.getText().equalsIgnoreCase(username))
{
System.out.println("Searched username is " +element.getText());
}
}
}
public boolean Issearchdetailsdisplayed() 
{
	
	System.out.println("Search detail is" +searchDetailsTable.getText());
    return searchDetailsTable.isDisplayed();
}
public boolean Iserrormessagedisplayed()
{
	System.out.println("Search detail is" +resultnotfound.getText());
    return searchDetailsTable.isDisplayed();
}
}
