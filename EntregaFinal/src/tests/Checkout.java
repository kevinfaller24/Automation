package tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import pages.SearchResult;
import parameters.UsersAndProducts;

public class Checkout extends BaseTest{
  @Test (dataProvider="UsersAndProducts", dataProviderClass=UsersAndProducts.class)
  public void checkout(String user, String password, String product) {
	  homePage.searchProduct(product);
		SearchResult searchPage=homePage.clickSearchButton();
		searchPage.findProductName(product);
		assertEquals("Product name: "+searchPage.getProductName()+"is not the expected: "+product, product, searchPage.getProductName());
		ProductPage productPage=searchPage.clickProduct();
		assertEquals("Product page: "+productPage.getProductName()+"is not the expected: "+product, product, productPage.getProductName());
		productPage.clickAddToCart();
		assertTrue(productPage.getSuccessAlert().isDisplayed());
		CartPage cart=productPage.clickCart();
		cart.findProductName(product);
		assertEquals("Product name: "+cart.getProductName()+"is not the expected: "+product, product, cart.getProductName());
		CheckoutPage checkout=cart.clickCheckout();
		checkout.inputEmail(user);
		checkout.inputPassword(password);
		checkout.clickLogin();
		checkout.clickBillingDetailsContinue();
		checkout.clickDeliveryDetailsContinue();
		checkout.clickDeliveryMethodContinue();
		checkout.agreeTermsAndConditions();
		checkout.clickPaymentMethodContinue();
		assertEquals("Product name: "+checkout.getProductName()+"is not the expected: "+product, product, checkout.getProductName());
		checkout.clickConfirmOrder();
		assertEquals("Order succcess message: "+checkout.getSuccessOrderMessage()+" is not the expected:'Your order has been placed!' ", "Your order has been placed!", checkout.getSuccessOrderMessage());
  }
}
