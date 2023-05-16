package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoints.ListVariantsEndPoints;
import api.payload.ListVariantQuestionsPojo;
import io.restassured.response.Response;

public class ListVariantsTest {
	
	static String variant_id;
	ListVariantQuestionsPojo listVariantsPayload ;
	
	
	public void setupData(ITestContext context) {
		
listVariantsPayload =  new ListVariantQuestionsPojo();
		
		String city =  (String) context.getAttribute(PincodeServiceableTests.City);
		String variant_slug =  (String) context.getAttribute(DetectDeviceTests.variant_slug);
		
		listVariantsPayload.setCity(city);
		listVariantsPayload.setExchange_method("sell");
		listVariantsPayload.setVariantSlug(variant_slug);
		
		
	}
	
	
    @Test(priority=6)
	public void testListVariantQuestions(ITestContext context) {
    	

    Response response = ListVariantsEndPoints.listVariantsQuestions(listVariantsPayload, ITestContext context);
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	variant_id= 	response.jsonPath().get("variant_details.variant_id");
	System.out.println("Variant slug is " +variant_id );
	context.getSuite().setAttribute("variant_id is ", variant_id);
		
	}
	
	
}
