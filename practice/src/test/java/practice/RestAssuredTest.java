//package practice;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.json.simple.JSONObject;
//import org.junit.Assert;
//import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class RestAssuredTest {
// 
//	@Test
//	public void GetWeatherDetails()
//	{   
//		// Specify the base URL to the RESTful web service
//		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
//
//		// Get the RequestSpecification of the request that you want to sent
//		// to the server. The server is specified by the BaseURI that we have
//		// specified in the above step.
//		RequestSpecification httpRequest = RestAssured.given();
//
//		// Make a request to the server by specifying the method Type and the method URL.
//		// This will return the Response from the server. Store the response in a variable.
//		Response response = httpRequest.request(Method.GET, "/Hyderabad");
//
//		// Now let us print the body of the message to see what response
//		// we have recieved from the server
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body is =>  " + responseBody);
//		String headers = response.getHeaders().toString();
//		System.out.println("Headers is => " + headers);
//		int statuscode = response.getStatusCode();
//		System.out.println("Response code is => " + statuscode);
//		
//		JsonPath jpath = response.jsonPath();
//		String city = jpath.get("City");
//		System.out.println("City using Jath is => " + city);
//
//	}
//	
//	@Test
//	public void query_parameter()
//	{
//		RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1";
//		
//		RequestSpecification httprequest = RestAssured.given();
//		
//		Response response = httprequest.queryParam("ISBN", "9781449325862").get("/Book");
//		String rbody = response.getBody().asString();
//		System.out.println("Book v1 is => " + rbody);
//		Response all_response = httprequest.get();
////		System.out.println("All book body is => " + all_response.getBody().asString());
//	}
//	
//	@Test
//	public void post_practice() {
//		
//		RestAssured.baseURI = "https://gorest.co.in/public/v2";
//		
//		RequestSpecification httprequest = RestAssured.given();
//		
//		// Create a request body json content
//		JSONObject reqbody = new JSONObject();
//		reqbody.put("name", "Virender"); 
//		String generatedString = RandomStringUtils.random(7, true, false);
//		reqbody.put("email", "someuser" + generatedString + "@gmail.com");
//		reqbody.put("gender", "male");
//		reqbody.put("status", "active");
//		reqbody.put("message", "TEST MESSAGE");
//		
//		// POST request header.
//		httprequest.header("Content-Type", "application/json");
//		httprequest.header("Authorization", "Bearer 0677a12e1d10ec5337ffa6db3be5ed4c53c4f8cb1036978c8aff235b7fdbcb83");
//		
//		httprequest.body(reqbody.toJSONString());
//		
//		Response post_response = httprequest.post("/users");
//		System.out.println("Post request response body => " + post_response.getBody().asString());
//		System.out.println("Response code is => " + post_response.getStatusCode());
//		
//		// To get the response content in json format.
//		JsonPath jpath = post_response.jsonPath();
//		int user_id = jpath.get("id");
//		
//		// id to request PUT and delete requests.
//		System.out.println("user_id => " + user_id);
//		JSONObject put_body = new JSONObject();
//		put_body.put("gender", "male");
//		put_body.put("name", "Updated name");
//		httprequest.body(put_body.toJSONString());
//		Response put_response = httprequest.patch("/users/" + user_id);
//		System.out.println(put_response.getBody().asString());
//		
//		Response del_response = httprequest.delete("/users/" + user_id);
//		System.out.println("Delete response data =>" + del_response.getStatusCode());
//		
//	}
//	
//	@Test
//	public void self_practise() {
//		
//		RestAssured.baseURI = "https://gorest.co.in/public/v2";
//		
//		RequestSpecification httprequest = RestAssured.given();
//		JSONObject post_body = new JSONObject();
//		post_body.put("name", "test");
//		post_body.put("email", "harsh.shah" + RandomStringUtils.random(5, true, true) + "@gmail.com");
//		post_body.put("gender", "male");
//		post_body.put("status", "active");
//		httprequest.body(post_body.toJSONString());
//		httprequest.header("Content-Type", "Application/json");
//		httprequest.header("Authorization", "Bearer 0677a12e1d10ec5337ffa6db3be5ed4c53c4f8cb1036978c8aff235b7fdbcb83");
//		
//		Response post_response = httprequest.post("/users");
//		JsonPath resp_json = post_response.jsonPath();
//		int uid = resp_json.getInt("id");
//		
//		JSONObject updated_body = new JSONObject();
//		updated_body.put("email", RandomStringUtils.random(5, true, true) + "@gmail.com");
//		httprequest.body(updated_body.toJSONString());
//		Response put_response = httprequest.put("/users/" + uid);
//		
//		Assert.assertEquals(put_response.getStatusCode(), 200);
//		
//		
//		Response del_response =  httprequest.request(Method.DELETE, "/users/" + uid);
//		Assert.assertEquals(del_response.getStatusCode(), 204);
//	}
//	
//	
//}
