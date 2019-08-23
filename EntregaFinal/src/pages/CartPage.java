package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
	
	private WebElement productName;
	
	public void findProductName (String productName) {
		this.productName= driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//a[text()=\""+productName+"\"]"));
	}
	
	public String getProductName(){
		return productName.getText();
	}
	
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
