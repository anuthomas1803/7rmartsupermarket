package testscript;

import org.testng.annotations.Test;

import pages7r.AdminUsersAdd7r;
import pages7r.Home;
import pages7r.LoginPage7r;
import utility.ExcelUtility;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

public class AdminUsersAdd7rTest extends LoginPageTest7r {
	
	public Home Homepage;
	public AdminUsersAdd7r adminuser;
	
  @Test
  public void verifyifAdminIsAbletoaddnewuser() throws AWTException, IOException {
	  LoginPage7r login=new LoginPage7r(driver); 
	  String username=ExcelUtility.readStringData(1,0,"Sheet1");
	  String password=ExcelUtility.readStringData(1,1,"Sheet1");
	  login.enter_usernamefield(username);
	  login.enter_passwordfield(password);
	  Homepage=login.click_signinbuton();                    //  login.click_signinbuton();
	  adminuser=Homepage.moreinfo();
	  adminuser.createnew();
	//  String username2=ExcelUtility.readStringData(1,0,"Sheet2");
	 // String password2=ExcelUtility.readStringData(1,1,"Sheet2");
	  adminuser.enter_username("Zaqura");
	  adminuser.enter_password("3234556");
	  adminuser.userType();
	  adminuser.savedetails();
	                                //   AdminUsersAdd7r admin= new  AdminUsersAdd7r(driver); 
	   // admin.adminclick();
	   // admin.Addadminuser();    
	      // user.NewadminUserspg();
	    //user.enter_username("Zaqura");
	    //user.enter_password("3234556");
	    //user.userType();
	    //user.savedetails();
   boolean isnewusersaved=adminuser.isSavesuccess(); 
	  assertTrue(isnewusersaved,"Alert!! userame already exists");//actual result=expected result	  
	  }
	}


