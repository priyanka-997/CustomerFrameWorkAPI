package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.LoginPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndPoints {
	
	public static Response Login(LoginPojo payload){
		
		Response response= 	given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
			.when()
			.post(Routes.login_post_url);
		
		return response;
					
		}
					
		public static Response ResendOtp(LoginPojo payload){
			
			Response response= 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
							
				.when()
				.post(Routes.resend_otp_post_url);
			
			return response;	
	}
				
	public static Response verifyOtp(LoginPojo payload){
		
		Response response= 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
					
					.when()
				    .post(Routes.verify_otp_post_url);				
			
			return response;	
	}
		
	}

