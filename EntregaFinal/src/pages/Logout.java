package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout extends BasePage {

	public Logout(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart Logout Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.className("account-logout");
	}

}
