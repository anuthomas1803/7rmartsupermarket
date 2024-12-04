package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages7r.AdminUserSearch7r;
import pages7r.LoginPage7r;


public class AdminUserSearch7rTest extends AdminUsersAdd7rTest {
@Test
	public void searchpge() throws AWTException
{

	  LoginPage7r login=new LoginPage7r(driver); 
	  login.enter_usernamefield("admin");
	  login.enter_passwordfield("admin");
	  login.click_signinbuton();
}	
	@DataProvider(name="searchuser")
	public Object[][] testData()        //Object is a class
	{
	// Object data[][]= {{"Emma Sarah","Admin"},{"Emma Sarah","Staff"}};
		Object data[][]= {{"Emma Sarah","2"},{"Emma Sarah","1"}};
	return data; 
	}
	 

	@Test(dataProvider = "searchuser")
	  
 
  public void verifyifAdminIsAbletosearchnewuser(String username, String usertype) throws AWTException {
	
	  
	  driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/user/add");
	  AdminUserSearch7r search=new AdminUserSearch7r(driver,"Sarah");
	  search.searchoption();
	  search.usernameSearch(username);
	  search.usertypeSearch(usertype);
	  search.searchuser();
	  search.Search_ParticularElements();
	  boolean isSearchdetailsLoaded=search.Issearchdetailsdisplayed();
	   assertTrue(isSearchdetailsLoaded,"Result Not found");	
	     
  }  
  @Test
  public void verifyifmessageDisplayedforinvalidsearch() throws AWTException
  {
  LoginPage7r login=new LoginPage7r(driver); 
  login.enter_usernamefield("admin");
  login.enter_passwordfield("admin");
  login.click_signinbuton();
  
  driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/user/add");
  AdminUserSearch7r search=new AdminUserSearch7r(driver,"Emma Sarah");
  search.searchoption();
  search.usernameSearch("Emma");
  search.usertypeSearch("Staff");
  search.searchuser();
  search.Search_ParticularElements();
  boolean isErrormessageloaded=search.Iserrormessagedisplayed();
  assertTrue(isErrormessageloaded,"No message");
}}