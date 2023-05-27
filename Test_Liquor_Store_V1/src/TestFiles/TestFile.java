package TestFiles;

import org.testng.annotations.Test;


import Pages.HomePage01;
import Pages.RegisterPage;
import utils.AutomationHelper;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class TestFile extends AutomationHelper {
	
	@DataProvider
	public Object[][] login(){
		return new Object[][] {
		      new Object[] { "SASAIDU","123","Golden Liquor"},
		      //new Object[] { "aaa","aaa","Paris", "New York", "September", "Blue Skies Airlines", "After flight finder - No Seats Avaialble"},
		};
		
		}
	
	@Test(dataProvider = "login")
	public void test001(String uname,String password, String expectedValue)throws IOException  {
		
		HomePage01 Store_homepage = new HomePage01();
		
		Store_homepage.Store_loginpage(driver,"http://localhost/liquor/",  uname, password);
		Store_homepage.storeLogin_verifydetails(driver, expectedValue);
		
		
		
	}
	
	
	@DataProvider
	public Object[][] dt_test002(){
		return new Object[][] {
		      new Object[] { "smil","Wikarmarathna", "SASIDU", "amila35@gmail.com", "075735555", "Homagama","1997","Female","123","123","WINE"},
		      //new Object[] { "aaa","aaa","Paris", "New York", "September", "Blue Skies Airlines", "After flight finder - No Seats Avaialble"},
		};
	}
	
	@Test(dataProvider = "dt_test002")
	public void test002(String fname,String lname, String uname, String email, String number ,String city, String birthyear,String gender,  String password1, String cpassword, String expectedValue)throws IOException  {
		
		RegisterPage Store_registerPage = new RegisterPage();
		
		
		Store_registerPage.storeRegister_link(driver, "http://localhost/liquor/index.php");
		Store_registerPage.store_registerDetails(driver, fname, lname, uname, email, number, city, birthyear, gender, password1, cpassword);
		Store_registerPage.store_verifyFRegisterDetails(driver, expectedValue);
		
		
		
		
	}
}
