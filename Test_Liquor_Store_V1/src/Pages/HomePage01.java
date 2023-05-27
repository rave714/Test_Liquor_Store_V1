package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Runtime.ActionCommand;

public class HomePage01 extends ActionCommand {
	By tf_UserName = By.xpath("//input[@name ='username']");
	By tf_Password = By.xpath("//input[@name ='password']");
	By btn_Login = By.xpath("//button[text()='LOGIN']");
	 By ele_ValidationText = By.xpath("//font[contains(text(), 'Golden Liquor')]");

	public void Store_loginpage(WebDriver driver,String url,String userName,String password) throws IOException {
		open(driver, url);
		type(driver, tf_UserName, userName);
		type(driver, tf_Password, password);
		click(driver, btn_Login);
		
	}
	
	public void storeLogin_verifydetails(WebDriver driver, String expectedText) throws IOException   {
		
		verifyByText(driver, ele_ValidationText, expectedText);
	}
}
