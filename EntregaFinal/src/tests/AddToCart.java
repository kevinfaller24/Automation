package tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import pages.SearchResult;
import parameters.ProductsList;

public class AddToCart extends BaseTest {
	
	@Test(dataProvider="ProductsList", dataProviderClass=ProductsList.class)
	public void addProductToCart(String product) {
		homePage.searchProduct(product);
		SearchResult searchPage=homePage.clickSearchButton();
		searchPage.findProductName(product);
		assertEquals("Product name: "+searchPage.getProductName()+"is not the expected: "+product, searchPage.getProductName(),product);
		//ProductPage productPage=searchPage
	}
}
