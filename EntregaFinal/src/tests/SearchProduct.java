package tests;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import pages.SearchResult;
import parameters.ProductsList;

public class SearchProduct extends BaseTest{
  
	@Test(dataProvider="ProductsList", dataProviderClass=ProductsList.class)
	public void searchProduct(String product) {
		homePage.searchProduct(product);
		SearchResult searchPage=homePage.clickSearchButton();
		searchPage.findProductName(product);
		assertEquals("Product name: "+searchPage.getProductName()+"is not the expected: "+product, searchPage.getProductName(),product);
  }
}
