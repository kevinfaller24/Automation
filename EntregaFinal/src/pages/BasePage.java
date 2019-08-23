package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	@FindBy(how=How.XPATH, using= "//div[@id=\"top-links\"]//a[@title=\"Shopping Cart\"]")
	private WebElement cart;
	@FindBy(how=How.XPATH, using= "//div[@id=\"top-links\"]//a[@title=\"My Account\"]")
	private WebElement myAccount;
	@FindBy(how=How.XPATH, using= "//div[@id=\"top-links\"]//a[text()=\"Login\"]")
	private WebElement login;
	@FindBy(how=How.XPATH, using= "//div[@id=\"top-links\"]//a[text()=\"Logout\"]")
	private WebElement logout;
	
	public WebDriverWait wait;
	public static WebDriver driver;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public CartPage clickCart() {
		cart.click();
		return PageFactory.initElements(driver, CartPage.class);
	}
	
	public BasePage (WebDriver driver) {
		BasePage.driver=driver;
		wait = new WebDriverWait(driver, 20);
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
