package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
	
	@FindBy (how=How.ID, using= "input-email")
	private WebElement inpEmail;
	@FindBy (how=How.ID, using= "input-password")
	private WebElement inpPassword;
	@FindBy (how=How.ID, using= "button-login")
	private WebElement btnLogin;
	private WebElement btnContinue;
	@FindBy (how=How.NAME, using="agree")
	private WebElement chkTermsAndConditions;
	@FindBy (how=How.ID, using= "button-confirm")
	private WebElement btnConfirmOrder;
	@FindBy (how=How.XPATH, using= "//div[@id=\"collapse-checkout-confirm\"]//a")
	private WebElement productName;
	@FindBy(how=How.CSS, using="#content h1")
	private WebElement successOrderMessage;
	
	private final String SUCCESS_ORDER_STRING = "Your order has been placed!";
	
	public String getSuccessOrderMessage() {
		wait.until(ExpectedConditions.textToBePresentInElement(successOrderMessage,SUCCESS_ORDER_STRING));
		return successOrderMessage.getText();
	}
	
	public void clickConfirmOrder() {
		btnConfirmOrder.click();
	}
	public String getProductName() {
		return productName.getText();
	}
	
	public void clickBillingDetailsContinue() {
		btnContinue=driver.findElement(By.id("button-payment-address"));
		btnContinue.click();
	}
	
	public void clickDeliveryDetailsContinue() {
		btnContinue=driver.findElement(By.id("button-shipping-address"));
		btnContinue.click();
	}
	
	public void clickDeliveryMethodContinue() {
		btnContinue=driver.findElement(By.id("button-shipping-method"));
		btnContinue.click();
	}
	
	public void clickPaymentMethodContinue() {
		btnContinue=driver.findElement(By.id("button-payment-method"));
		btnContinue.click();
	}
	
	public void agreeTermsAndConditions() {
		chkTermsAndConditions.click();;
	}
	public void inputEmail(String email) {
		inpEmail.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		inpPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		if(!this.isLoaded()) {
			throw new IllegalStateException("This is not the Abstracta Open Cart Checkout Page");
		}
	}
	@Override
	public By getPageLoadLocator() {
		return By.className("checkout-checkout");
	}

}
