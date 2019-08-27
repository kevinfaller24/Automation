package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonHome extends BasePage {
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"search\"]//input")
	private WebElement inpSearch;
	@FindBy(how=How.XPATH, using = "//*[@id=\"search\"]//button")
	private WebElement btnSearch;
	
	public void searchProduct(String product) {
		inpSearch.sendKeys(product);
	}
	
	public SearchResult clickSearchButton() {
		btnSearch.click();
		return PageFactory.initElements(driver, SearchResult.class);
	}
	
	public CommonHome(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart CommonHome Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.className("common-home");
	}
	
	
}
