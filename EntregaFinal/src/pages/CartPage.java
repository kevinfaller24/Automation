package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage {
	
	@FindBy(how=How.XPATH, using= "//button[@class=\"btn btn-danger\"]")
	private WebElement btnRemove;
	private WebElement productName;
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]//p")
	private WebElement cartEmptyMessage;
	@FindBy (how=How.XPATH, using ="//input[starts-with(@name,\"quantity\")]")
	private WebElement inpQuantity;
	
	public void findProductName (String productName) {
		this.productName= driver.findElement(By.xpath("//div[@class=\"table-responsive\"]//a[text()=\""+productName+"\"]"));
	}
	public String getQuantityValue() {
		return inpQuantity.getAttribute("value").toString();
	}
	
	public String getCartEmptyMessage() {
		return cartEmptyMessage.getText();
	}
	public String getProductName(){
		return productName.getText();
	}
	
	public void clickRemoveButton() {
		btnRemove.click();
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
