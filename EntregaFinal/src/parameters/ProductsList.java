package parameters;

import org.testng.annotations.DataProvider;

public class ProductsList {
	@DataProvider(name="ProductsList")
    public static Object[][] getProductsList(){
        return new Object[][] {
            { "iPhone" }/*,
            { "MacBook"},
            { "MacBook Air"},
            {"Samsung Galaxy Tab 10.1"},
            {"Palm Treo Pro"}
     */   }; 
}
}