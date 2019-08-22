package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult extends BasePage {
	
	
	
	public SearchResult(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart SearchResult Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.className("product-search");
	}

}
