package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AutomationHelper {
	protected WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		String os = System.getProperty("os.name").toLowerCase();
		File driverFile;

		if (os.contains("win")) {
			driverFile = new File("libraries" + File.separator + "chromedriver.exe");
		} else if (os.contains("mac")) {
			driverFile = new File("libraries" + File.separator + "chromedriver");
		} else {
			throw new Exception("Operating system not yet supported");
		}

		System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
