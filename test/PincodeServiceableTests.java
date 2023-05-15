package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.PincodeServiceableEndPoints;
import api.payload.PincodeServiceablePojo;
import io.restassured.response.Response;

public class PincodeServiceableTests {
	
	static String City;
	PincodeServiceablePojo pincodePayload;
	
	@BeforeClass()
	public void setupData() {
		
		pincodePayload= new PincodeServiceablePojo();
		
		pincodePayload.setPincode(201301);
		pincodePayload.setCategory("mobile");
		pincodePayload.setOrder_type("sell");
		
}

	@Test(priority=4)
	public void pincodeServiceable(ITestContext context) {
		Response response= PincodeServiceableEndPoints.pincodeServiceable(pincodePayload);
		
		response.then().log().all();
	
		Assert.assertEquals(response.jsonPath().getString("message" ), "Pincode is serviceable");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		City = response.jsonPath().getString("details.pincode_city");
		System.out.println("Pincode city is " +City);
		context.getSuite().setAttribute("city", City);

}}