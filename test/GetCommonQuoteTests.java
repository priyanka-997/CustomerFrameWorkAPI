package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GetCommonQuoteEndPoints;
import api.endpoints.GlobalVariables;
import io.restassured.response.Response;

public class GetCommonQuoteTests {
	
	static String[] GetCommonQuotePayload= {"\"exchange_method\", \"sell\""
				        + " \"variant_id\", \"GlobalVariables.variant_id\""
						+ "\"servicer_id\", \"187\""
				        +"\"variantSlug\", \"GlobalVariables.variant_slug\""
						+"\"city\", \"GlobalVariables.city\""
						+"\"answer_sets[box]\", \"Y\""
						+"\"answer_sets[display_glass_broken]\",\"N\""
						+"\"answer_sets[touch_issue]\", \"S\""
						+"\"answer_sets[body_condition]\",\"N\""
						+"\"answer_sets[front_camera_faulty]\",\"Y\"" 
						+"\"answer_sets[mobile_number]\", \"GlobalVariables.mobileNumber\""
						+"\"answer_sets[back_camera_faulty]\",\"N\""
						+"\"answer_sets[ram]\", \"4.0\""
						+"\"answer_sets[internal_storage]\", \"64\""
						+"\"answer_sets[fingerprint_faulty]\",\"N\""
						+"\"answer_sets[wifi_faulty]\", \"N\""
						+"\"answer_sets[bluetooth_faulty]\",\"N\""
						+"\"answer_sets[speaker_faulty]\", \"N\""
						+"\"answer_sets[mic_faulty]\",\"N\""
						+"\"answer_sets[proximity_sensor_faulty]\", \"N\""
						+"\"answer_sets[charging_jack_faulty]\", \"N\""
						+"\"answer_sets[volume_buttons_faulty]\",\"N\""
						+"\"answer_sets[vibrator_faulty]\",\"N\""
						+"\"answer_sets[cellular_faulty]\", \"N\""
						+"\"answer_sets[device_imei_number]\",\"123456789012345\""
						+"\"answer_sets[product_model_number]\",\"RMX1971\""};
		

	@Test(priority=7)
	public void testGetCommonQuotes() {
									
		Response response = GetCommonQuoteEndPoints.getCommonQuote(GetCommonQuotePayload);
				
				response.then().log().all();
				Assert.assertEquals(response.jsonPath().getString("message"), "Success");
				Assert.assertEquals(response.getStatusCode(), 200);
				
			GlobalVariables.quote_id = 	response.jsonPath().getString("quote_details.quote_id");
			System.out.println("Generated quote id is " +GlobalVariables.quote_id );
			
		
		
	}
	
}
	
