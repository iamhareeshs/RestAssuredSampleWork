package apitest.apibasis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import testdata.NeoTestDetails;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import apitest.expectedresponse.objects.ExpectedResponseObjects;
import apitest.response.objects.ResponseObjects;
import apitest.utility.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NeoFeedTest extends NeoFeedService {
	Util util = new Util();

	/**
	 * 
	 */
	@Test(testName = "Validate API response without start and end date", priority = 1)
	private void verifyWithoutStartDateAndEndDate() {
		RestAssured.given().param("api_key", API_KEY).when().get(NASA_NEO_FEED_URL).then().assertThat()
				.statusCode(HttpStatus.SC_OK);
	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response without start date", priority = 2)
	private void verifyWithoutStartDate() {
		RestAssured.given().param("end_date", END_DATE).param("api_key", API_KEY).when().get(NASA_NEO_FEED_URL).then()
				.assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);

	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response without end date", priority = 3)
	private void verifyWithoutEndDate() {
		RestAssured.given().param("start_date", START_DATE).param("api_key", API_KEY).when().get(NASA_NEO_FEED_URL)
				.then().assertThat().statusCode(HttpStatus.SC_OK);

	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response for swapped start and end date", priority = 4)
	private void verifySwappedStartDateAndEndDate() {
		RestAssured.given().param("start_date", END_DATE).param("end_date", START_DATE).param("api_key", API_KEY).when()
				.get(NASA_NEO_FEED_URL).then().assertThat().statusCode(HttpStatus.SC_OK);

	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response for invalid date format for start and end date", priority = 5)
	private void verifyInvalidDateFormat() {
		Response response = RestAssured.given().param("start_date", "Invalid_Date_Format")
				.param("end_date", "Invalid_Date_Format").param("api_key", API_KEY).when().get(NASA_NEO_FEED_URL);
		response.then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).body("error_message", Matchers.equalTo(
				"Date Format Exception - Expected format (yyyy-mm-dd) - Invalid_Date_Format - Unparseable date: \"Invalid_Date_Format\""));
	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response for invalid API KEY", priority = 6)
	private void verifyUsingInvalidAPIKey() {
		Response response = RestAssured.given().param("api_key", "Invalid_API_Key").when().get(NASA_NEO_FEED_URL);
		response.then().assertThat().statusCode(HttpStatus.SC_FORBIDDEN).body("error.code",
				Matchers.equalTo("API_KEY_INVALID"));

	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response for without API KEY", priority = 7)
	private void verifyWithoutAPIKey() {
		Response response = RestAssured.given().when().get(NASA_NEO_FEED_URL);
		response.then().assertThat().statusCode(HttpStatus.SC_FORBIDDEN).body("error.code",
				Matchers.equalTo("API_KEY_MISSING"));

	}

	/**
	 * 
	 */
	@Test(testName = "Validate API response for valid start and end date", priority = 8)
	private void verifyUsingValidStartDateAndEndDate() {
		RestAssured.given().param("start_date", START_DATE).param("end_date", END_DATE).param("api_key", API_KEY).when()
				.get(NASA_NEO_FEED_URL).then().assertThat().statusCode(HttpStatus.SC_OK);
		RestAssured.given().param("","").get("").then().assertThat().statusCode(HttpStatus.SC_OK);
	}

	/**
	 * @param testData
	 * @throws FileNotFoundException
	 */
	@Test(testName = "Validate API response for different fields according to Expected API Response data", dataProvider = "getTestData", priority = 9)
	private void verifyUsingValidTestDetails(NeoTestDetails testData) throws FileNotFoundException {
		String startDate = testData.getStartDate().trim();
		String endDate = testData.getendDate().trim();
		String filename = testData.getfileName().trim();
		Response response = RestAssured.given().param("start_date", startDate).param("end_date", endDate)
				.param("api_key", API_KEY).when().get(NASA_NEO_FEED_URL);
		ResponseObjects responseObject = response.getBody().as(ResponseObjects.class);
		BufferedReader br = new BufferedReader(new FileReader(".//src/resources/" + filename));
		ExpectedResponseObjects expectedResponseObject = new Gson().fromJson(br, ExpectedResponseObjects.class);
		long actual_element_count = responseObject.getElementCount();
		long expected_element_count = expectedResponseObject.getElementCount();
		String actual_name = responseObject.getNearEarthObjects().get(startDate)[0].getName().trim();
		String expected_name = expectedResponseObject.getNearEarthObjects().get(startDate)[0].getName().trim();
		boolean actual_is_potentially_hazardous_asteroid = responseObject.getNearEarthObjects().get(startDate)[0]
				.getIsPotentiallyHazardousAsteroid();
		boolean expected_is_potentially_hazardous_asteroid = expectedResponseObject.getNearEarthObjects()
				.get(startDate)[0].getIsPotentiallyHazardousAsteroid();
		double actual_kilometers_min = responseObject.getNearEarthObjects().get(startDate)[0].getEstimatedDiameter()
				.getKilometers().getEstimatedDiameterMin();
		double expected_kilometers_min = expectedResponseObject.getNearEarthObjects().get(startDate)[0]
				.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin();
		double actual_kilometers_max = responseObject.getNearEarthObjects().get(startDate)[0].getEstimatedDiameter()
				.getKilometers().getEstimatedDiameterMax();
		double expected_kilometers_max = expectedResponseObject.getNearEarthObjects().get(startDate)[0]
				.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax();

		Assert.assertEquals(actual_element_count, expected_element_count, "Element count mismatching!");
		Assert.assertEquals(actual_name, expected_name, "Name mismatching!");
		Assert.assertTrue(actual_kilometers_max - actual_kilometers_min > 0,
				"Estimated diameter min value is greater than max value !");
		Assert.assertEquals(actual_kilometers_max - actual_kilometers_min,
				expected_kilometers_max - expected_kilometers_min,
				"Difference in max and min estimated diameter in kilometers has been found to have mismatch!");
		Assert.assertEquals(actual_is_potentially_hazardous_asteroid, expected_is_potentially_hazardous_asteroid,
				"Potentially hazardous asteroid value in response is not as expected!");
	}

	/**
	 * Method Name: getTestData    Method Description: Used to fetch data in file from provided location.
	 * @return
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] getTestData() throws Exception {
		File file = new File(".//src/resources/testDataDetails.json");
		return Util.fetchDataFromJson(file, NeoTestDetails.class);
	}

}
