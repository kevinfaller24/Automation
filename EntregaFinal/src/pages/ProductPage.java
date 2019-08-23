package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {
	
	@FindBy (how=How.XPATH, using = "//button[@id=\"button-cart\"]")
	private WebElement btnAddToCart;
	@FindBy (how=How.XPATH, using = "//h1")
	private WebElement productName;
	@FindBy (how=How.XPATH, using = "//input[@id=\"input-quantity\"]")
	private WebElement inpQuantity;
	@FindBy (how=How.XPATH, using = "//div[@class=\"alert alert-success\"]")
	private WebElement alertSuccess;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart Product Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.xpath("//body[starts-with(@class,'product-product')]");
	}

}
