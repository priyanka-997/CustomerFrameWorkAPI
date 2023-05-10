package api.endpoints;

public class Routes {
	
	//Login
	
	public static String base_url = "https://qarapiv2.recycledevice.com";
	public static String login_post_url= base_url +"/api/login/send-otp";
	public static String resend_otp_post_url= base_url +"/api/login/resend-otp";
	public static String verify_otp_post_url= base_url +"/api/login/verify-otp";
	
}
