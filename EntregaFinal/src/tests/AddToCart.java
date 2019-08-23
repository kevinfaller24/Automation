package tests;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductPage;
import pages.SearchResult;
import parameters.ProductsList;

public class AddToCart extends BaseTest {
	
	@Test(dataProvider="ProductsList", dataProviderClass=ProductsList.class)
	public void addProductToCart(String product) {
		homePage.searchProduct(product);
		SearchResult searchPage=homePage.clickSearchButton();
		searchPage.findProductName(product);
		assertEquals("Product name: "+searchPage.getProductName()+"is not the expected: "+product, searchPage.getProductName(),product);
		ProductPage productPage=searchPage.clickProduct();
		assertEquals("Product page: "+productPage.getProductName()+"is not the expected: "+product, productPage.getProductName(),product);
		productPage.clickAddToCart();
		assertTrue(productPage.getSuccessAlert().isDisplayed());
		CartPage cart=productPage.clickCart();
		cart.findProductName(product);
		assertEquals("Product name: "+cart.getProductName()+"is not the expected: "+product, cart.getProductName(),product);
	}
}
