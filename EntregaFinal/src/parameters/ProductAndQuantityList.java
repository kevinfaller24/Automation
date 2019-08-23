package parameters;

import org.testng.annotations.DataProvider;

public class ProductAndQuantityList {
	@DataProvider(name="ProductAndQuantityList")
    public static Object[][] getProductsList(){
        return new Object[][] {
            { "iPhone", "3" },
            { "MacBook", "2"},
            { "MacBook Air", "1"},
            {"Samsung Galaxy Tab 10.1", "4"},
            {"Palm Treo Pro", "2"}
        }; 
}
}
