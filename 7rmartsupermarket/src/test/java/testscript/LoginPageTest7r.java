package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages7r.LoginPage7r;
import utility.ExcelUtility;

import static org.testng.Assert.assertTrue;

public class LoginPageTest7r extends Base7r{

	  @Test
	  public void verifyUserIsAbleToLoginValidCredentials() throws AWTException
	 {
		  //object creation of login page
		  LoginPage7r login=new LoginPage7r(driver);
		  login.enter_usernamefield("admin");
		  login.enter_passwordfield("admin");
		  login.click_signinbuton(); 
		 boolean isHomepageLoaded=login.isDashBoardLoaded(); 
		 assertTrue(isHomepageLoaded,"!home page not loaded");//actual result=expected result
	 }
	  @Test
	  @Parameters({"username","password"})
	  public void verifyUserIsAbleToLoginInValidUsername(String username,String password) throws AWTException
	 {
		  //object creation of login page
		  LoginPage7r login=new LoginPage7r(driver);
		  login.enter_usernamefield(username);
		  login.enter_passwordfield(password);
		  login.click_signinbuton(); 
		 boolean IsAlertDisplayed=login.alert(); 
		 assertTrue(IsAlertDisplayed," Home Page is not loaded ");//actual result=expected result
	 }
	  @Test
	  public void verifyUserIsAbleToLoginInValidPassword() throws AWTException
		 {
			  //object creation of login page
			  LoginPage7r login=new LoginPage7r(driver);
			  login.enter_usernamefield("admin");
			  login.enter_passwordfield("admin123456");
			  login.click_signinbuton(); 
			  boolean IsAlertDisplayed=login.alert(); 
				 assertTrue(IsAlertDisplayed,Constant.errormessageforlogin);//actual result=expected result
			 
		 }
	  
	  @DataProvider(name="credentials")
	  public Object[][] testData()        //Object is a class
	  {
	  Object data[][]= {{"admin12","1q2w3e4r"},{"admin","admin"},{"shefeena","19dte4r"}};	
	  return data; 
	  }
	   

	  @Test(dataProvider = "credentials")
	  public void verifyUserIsAbleToLoginInValidCredentials(String username,String password) throws AWTException
		 {
			  //object creation of login page
			  LoginPage7r login=new LoginPage7r(driver);
			  login.enter_usernamefield(username);
			  login.enter_passwordfield(password);
			  login.click_signinbuton(); 
			 boolean isHomepageLoaded=login.isDashBoardLoaded(); 
			 assertTrue(isHomepageLoaded," Alert! Invalid Username/Password");//actual result=expected result
		 }
	  
	  @Test
	  public void verifyUserIsAbleToLoginInValidPasswordExcel() throws AWTException, IOException
		 {
			  //object creation of login page
			  LoginPage7r login=new LoginPage7r(driver);
			  //excelread
			  String username=ExcelUtility.readStringData(1,0,"Sheet1");
			  String password=ExcelUtility.readStringData(1,1,"Sheet1");
			  login.enter_usernamefield(username);
			  login.enter_passwordfield(password);
			  login.click_signinbuton(); 
			  boolean IsAlertDisplayed=login.alert(); 
				 assertTrue(IsAlertDisplayed,Constant.errormessageforlogin);//actual result=expected result
			 
		 }
}
