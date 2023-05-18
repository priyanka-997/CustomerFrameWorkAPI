package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class VerifyIfscEndPoints {
	
	public static Response verifyIfsc() {
		Response response = (Response) given()
				
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.body(GlobalVariables.ifsc)
				
				
				.when()
				.post(Routes.verifyIfsc_post_url);
		
		return response;
		
	}
	}

