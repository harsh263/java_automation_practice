package base.functions;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertyFileHandler;

public class APIactions {
	
	RequestSpecification http_request;
	
	public void create_request_specification() throws IOException {
		String api_base_url = PropertyFileHandler.getApplicationPropertty("api_base_uri");
		RestAssured.baseURI = api_base_url;
		http_request = RestAssured.given();
	}
	
	public Response perform_get_request(String endpoint) {
		return http_request.get(endpoint);
	}
	
	public Response perform_post_request(String endpoint, String post_data_id) {
		try {
			http_request.header("content-type", PropertyFileHandler.getApplicationPropertty("content-type"));
			http_request.header("Authorization", PropertyFileHandler.getApplicationPropertty("authorization"));
			http_request.body(PropertyFileHandler.getApplicationPropertty(post_data_id));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return http_request.post(endpoint);
	}
}
