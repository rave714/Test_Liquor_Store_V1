package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Runtime.ActionCommand;

public class RegisterPage extends ActionCommand {

	By lnk_Register = By.xpath("//a[text()='Registration']");
	
	By tf_fname = By.xpath("//input[@name='fname']");
    By tf_lname = By.xpath("//input[@name ='lname']");
    By tf_uname = By.xpath("//input[@name ='uname']");
    By tf_email = By.xpath("//input[@name ='email']");
    By tf_number = By.xpath("//input[@name ='number']");
    By dd_city = By.xpath("//select[@name ='city']");
    By dd_birtday = By.xpath("//select[@name ='birthyear']");
    By dd_gender = By.xpath("//select[@name ='gender']");
    By tf_password1 = By.xpath("//input[@name='password1']");
    By tf_cpassword = By.xpath("//input[@name='cpassword']");
    By btn_register = By.xpath("/html/body/div[3]/table/tbody/tr/td[4]/div/form/button");
 
    By ele_lblValidationText = By.xpath("/html/body/div[3]/div/h3");

    public void storeRegister_link (WebDriver driver,String url ) throws IOException {
    	
		open(driver, url);
		
		
}
	 public void store_registerDetails(WebDriver driver, String fname,String lname, String uname, String email, String number ,String city, String birthyear,String gender,  String password1, String cpassword ) throws IOException  {
	  
		
		  
		click(driver, lnk_Register);
		type(driver, tf_fname,fname);
		type(driver, tf_lname,lname);
		type(driver, tf_uname, uname);
			
			type(driver, tf_email,email);
			type(driver, tf_number,number);
			

			select(driver, dd_city,city);
			select(driver, dd_birtday,birthyear);
			select(driver, dd_gender,gender);
			
			type(driver,tf_password1,password1);
			type(driver,tf_cpassword,cpassword);
			click(driver, btn_register);
		  
		  
		  
		  
	  
	  }
	  
	 

	public void store_verifyFRegisterDetails(WebDriver driver, String expectedText) throws IOException   {
		
		verifyByText(driver, ele_lblValidationText, expectedText);
	}

	
		// TODO Auto-generated method stub

	}
