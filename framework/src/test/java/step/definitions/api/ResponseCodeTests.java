package step.definitions.api;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.vimalselvam.cucumber.listener.Reporter;

import base.functions.APIactions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseCodeTests {
	
	private APIactions actions;
	private static Logger logger = Logger.getLogger(ResponseCodeTests.class);
	private Response response;
	private String new_user_id;
	
	@Given("^Create request specification$")
	public void create_request_specification() {
		actions = new APIactions();
		try {
			actions.create_request_specification();
			Reporter.addStepLog("Request specification created.");
		} catch (IOException e) {
			logger.debug("Not able to create request specification. Exception received as: " + e);
			Reporter.addStepLog("Exception occurred while creating request specification" + e);
			Assert.fail();
		}
		
	}

	@When("^Perform Get reuest with endpoint \"(.*)\"$")
	public void perform_Get_reuest_with_endpoint(String endpoint) {
		response = actions.perform_get_request(endpoint);
	}

	@Then("^Verify response message as \"(.*)\"$")
	public void verify_response_message_as_success(String status) {
		try {
		int status_code = response.getStatusCode();
		Assert.assertTrue(status_code == 200);
		}
		catch (Exception e){
			logger.debug("Not able to fetch response code. Exception received as: " + e);
			Reporter.addStepLog("Exception occurred while fetching response code" + e);
			Assert.fail();
		}
	}

	@When("^Perform Post reuest with endpoint \"(.*?)\" with \"(.*?)\"$")
	public void perform_Post_reuest_with_endpoint_with(String endpoint, String post_data_id) throws Throwable {
		try {
			response = actions.perform_post_request(endpoint, post_data_id);
			Reporter.addStepLog("Post request successful with given body.");
		}
		catch (Exception e) {
			logger.debug("Not able to get response for post request. Exception received as: " + e);
			Reporter.addStepLog("Exception occurred while fetching response code" + e);
			Assert.fail();
		}
	}
	
	@When("^get user id of new created user$")
	public void get_user_id_for_new_created_user() {
		try {
			
			JsonPath jpath = response.jsonPath();
			new_user_id = jpath.get("id");
			Reporter.addStepLog("Got new user id form response body.");
			
		}catch(Exception e) {
			logger.debug("Not able to get user id fron response body. Exception received as: " + e);
			Reporter.addStepLog("Exception occurred while fetching user id" + e);
			Assert.fail();
		}
	}

}
