package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	
	@FindBy(how=How.CSS, using="#input-email")
	private WebElement inpEmail;
	@FindBy(how=How.CSS, using="#input-password")
	private WebElement inpPassword;
	@FindBy(how=How.XPATH, using="//input[@type=\"submit\"]")
	private WebElement btnLogin;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart Login Page");
		}
	}

	@Override
	public By getPageLoadLocator() {
		
		return By.className("account-login");
	}

}
