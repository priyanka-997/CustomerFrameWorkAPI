package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.DetectDeviceEndPoints;
import api.payload.DetectDevicePojo;
import io.restassured.response.Response;

public class DetectDeviceTests {
	
	static String variant_slug;
	DetectDevicePojo detectDevicePayload;
	
	@BeforeClass()
	
	public void setupData() {
		
		 detectDevicePayload = new DetectDevicePojo();
		
		detectDevicePayload.setCpu_model("Qualcomm Technologies");
		detectDevicePayload.setInternal_memory(4);
		detectDevicePayload.setInternal_storage(64);
		detectDevicePayload.setModel_number("RMX1971");
	}
	
	@Test(priority=5)
	public void testDetectDevice(ITestContext context) {
		
	Response response = DetectDeviceEndPoints.detectDevice(detectDevicePayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	variant_slug= 	response.jsonPath().get("variant.product_url");
	System.out.println("Variant slug is " +variant_slug );
	context.getSuite().setAttribute("variant_slug", variant_slug);
	
	}
}
