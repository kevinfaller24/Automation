package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
	public static WebDriver driver;
	
	public BasePage (WebDriver driver) {
		BasePage.driver=driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public boolean isElementPresent (By locator) {
		try {
			driver.findElement(locator);
			return true;
		}catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public abstract By getPageLoadLocator();
	
	public final boolean isLoaded () {
		return isElementPresent(this.getPageLoadLocator());
	}
}
