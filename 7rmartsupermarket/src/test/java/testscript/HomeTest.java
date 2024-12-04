package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages7r.Home;
import pages7r.LoginPage7r;
import utility.ExcelUtility;

public class HomeTest extends Base7r{
public Home Homepage;//object declaration 

@Test
public void verifyUserIsAbleToLoginInValidPasswordExcel() throws AWTException, IOException
{
	
	  LoginPage7r login=new LoginPage7r(driver);
	  //excelread
	  String username=ExcelUtility.readStringData(1,0,"Sheet1");
	  String password=ExcelUtility.readStringData(1,1,"Sheet1");
	  login.enter_usernamefield(username);
	  login.enter_passwordfield(password);
	 // login.click_signinbuton(); 
	  Homepage=login.click_signinbuton();
	  Homepage.logout();
	     String expectedresult="Login|7rmart supermarket";
		 String actualresult=driver.getTitle();
		 assertEquals(actualresult,expectedresult,Constant.errormessageforlogin);//actual result=expected result
	 

}}
