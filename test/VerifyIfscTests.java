package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.VerifyIfscEndPoints;
import io.restassured.response.Response;

public class VerifyIfscTests {
	
	@Test(priority=11)
	public static void testVerifyIfsc() {
		
		Response response =  VerifyIfscEndPoints.verifyIfsc();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "success");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.time(), 500);
		
		System.out.println("Bank address is " +response.jsonPath().getString("data.ADDRESS"));
		
		
	}

}
