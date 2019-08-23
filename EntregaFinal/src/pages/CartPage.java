package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
	
	public CartPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart Cart Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.className("checkout-cart");
	}

}
