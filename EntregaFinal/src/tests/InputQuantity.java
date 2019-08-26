package tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductPage;
import pages.SearchResult;
import parameters.ProductAndQuantityList;

public class InputQuantity extends BaseTest{
  @Test(dataProvider="ProductAndQuantityList",dataProviderClass=ProductAndQuantityList.class )
  public void inputQuantity(String product, String quantity) {
	  homePage.searchProduct(product);
		SearchResult searchPage=homePage.clickSearchButton();
		searchPage.findProductName(product);
		assertEquals("Product name: "+searchPage.getProductName()+"is not the expected: "+product,product, searchPage.getProductName());
		ProductPage productPage=searchPage.clickProduct();
		assertEquals("Product page: "+productPage.getProductName()+"is not the expected: "+product,product, productPage.getProductName());
		productPage.setProductQuantity(quantity);
		productPage.clickAddToCart();
		assertTrue(productPage.getSuccessAlert().isDisplayed());
		CartPage cart=productPage.clickCart();
		cart.findProductName(product);
		assertEquals("Product name: "+cart.getProductName()+"is not the expected: "+product,product, cart.getProductName());
		assertEquals("Product quantity: "+cart.getQuantityValue()+"is not the expected: "+quantity, quantity,cart.getQuantityValue());
  }
}
