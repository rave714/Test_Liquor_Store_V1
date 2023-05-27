package Runtime;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class ActionCommand {
	protected WebDriver driver;

	public void open(WebDriver driver, String url) throws IOException {
		try {
			Reporter.log("Navigating to " + url, true);
			driver.get(url);
		} catch (InvalidArgumentException e) {
			Reporter.log("<br/>URL value is incorrect", true);
			
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("Error occured during the open action");
			
			throw e;
		}

	}
	
	

	public void click(WebDriver driver, By locator) throws IOException {
		try {
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			Reporter.log("<br/>Element is not present in the webpage : " + locator, true);
			
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			Reporter.log("<br/>Error occured during the click action : " + locator, true);
			
			e.printStackTrace();
			throw e;
		}

	}

	public void type(WebDriver driver, By locator, String value) throws IOException {
		try {
			WebElement element = driver.findElement(locator);
			
			element.clear();
			element.sendKeys(value);
		} catch (NoSuchElementException e) {
			Reporter.log("<br/>Element is not present in the webpage : " + locator, true);
			
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			Reporter.log("<br/>Error occured during the type action : " + locator, true);
			
			e.printStackTrace();
			throw e;
		}
	}

	public void select(WebDriver driver, By locator, String value) throws IOException {
		try {
			WebElement element = driver.findElement(locator);
			new Select(element).selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			Reporter.log("<br/>Element is not present in the webpage : " + locator, true);
			
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			Reporter.log("<br/>Error occured during the select action : " + locator, true);
			
			e.printStackTrace();
			throw e;
		}

	}

	public void verifyByText(WebDriver driver, By locator, String expectedText) throws IOException {
		try {
			WebElement element = driver.findElement(locator);
			assertEquals(element.getText().trim(), expectedText);
		} catch (NoSuchElementException e) {
			Reporter.log("<br/>Element is not present in the webpage : " + locator, true);
			
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			Reporter.log("<br/>Error occured during the verifyByText action : " + locator, true);
		
			e.printStackTrace();
			throw e;
		}
		

	}
	




}