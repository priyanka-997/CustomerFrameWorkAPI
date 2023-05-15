package api.endpoints;

import api.payload.ListVariantQuestionsPojo;
import api.test.LoginTests;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ListVariantsEndPoints {
	
	public static Response listVariantsQuestions(ListVariantQuestionsPojo listVariantsPayload,  ITestContext context) {
		
		String bearerToken = (String) context.getAttribute(LoginTests.token);	
		
	Response response =	given()
			.headers("Authorization", "Bearer " +bearerToken)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(listVariantsPayload)
		
		.when()
		.post(Routes.list_variant_questions_post_url);
		
		return response;
	}

}
