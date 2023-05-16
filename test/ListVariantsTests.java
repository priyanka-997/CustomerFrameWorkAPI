package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.GlobalVariables;
import api.endpoints.ListVariantsEndPoints;
import api.payload.ListVariantQuestionsPojo;
import io.restassured.response.Response;

public class ListVariantsTests {
	
	ListVariantQuestionsPojo listVariantsPayload ;
	
	@BeforeClass()
	public void setupData() {
		
listVariantsPayload =  new ListVariantQuestionsPojo();
		
		listVariantsPayload.setCity(GlobalVariables.City);
		listVariantsPayload.setExchange_method("sell");
		listVariantsPayload.setVariantSlug(GlobalVariables.variant_slug);		
	}
		
    @Test(priority=6)
	public void testListVariantQuestions() {
    	

    Response response = ListVariantsEndPoints.listVariantsQuestions(listVariantsPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	GlobalVariables.variant_id= response.jsonPath().get("variant_details.variant_id");
	System.out.println("Variant slug is " +GlobalVariables.variant_id );
		
	}
	
	
}
