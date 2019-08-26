package parameters;

import org.testng.annotations.DataProvider;

public class UsersAndProducts {

	@DataProvider(name="UsersAndProducts")
    public static Object[][] getUsersAndProductsList(){
        return new Object[][] {
            {"mmartinez@gmail.com","abc123", "HTC Touch HD" },
            {"pablop@hotmail.com","321.a.", "Palm Treo Pro"},
            {"cm11@gmail.com","pod313", "MacBook Air"},
            
        }; 
}
}


     
         
		