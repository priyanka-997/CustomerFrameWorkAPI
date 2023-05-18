package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.AddUpdateAddressEndPoints;
import io.restassured.response.Response;

public class AddUpdateAddressTests {
	
	static String[] addUpdateAddressPayload = {"house_no", "A-53", "street_no", "24", "locality", "Noida City Center",
			"pincode", "201301", "city", "Noida", "address_type", "Home", "state", "Uttar Pradesh"};

			
	@Test(priority=9)
	public static void testAddUpdateAddress() {
		
		Response response = AddUpdateAddressEndPoints.addUpdateAddress(addUpdateAddressPayload);
				response.then().log().all();
		
				Assert.assertEquals(response.jsonPath().getString("message"), "Address has been added");
				Assert.assertEquals(response.getStatusCode(), 200);
				Assert.assertEquals(response.jsonPath().getString("address_type"), "Home");
				Assert.assertEquals(response.time(), 200);
				
		
	
		
	}

}
