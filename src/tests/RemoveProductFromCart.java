package tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductPage;
import pages.SearchResult;
import parameters.ProductsList;

public class RemoveProductFromCart extends BaseTest {
  
	@Test(dataProvider="ProductsList", dataProviderClass=ProductsList.class)
	public void removeProductFromCart(String product) {
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
		cart.clickRemoveButton();
		assertEquals("'Your shopping cart is empty!' message is expected","Your shopping cart is empty!",cart.getCartEmptyMessage());
	}
}
