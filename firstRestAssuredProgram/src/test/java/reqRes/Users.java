package reqRes;

/***
 * @author Santhosh
 */

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Users {
	String baseUrl = "https://www.shoppersstack.com/shopping";

//	@Test
//	public void ListUsers() {
//		// given-->inputs
//		// when-->Http methods
//		// then-->Assertion/validation
//		RestAssured.given().when().get("https://reqres.in/api/users?page=2").
//		then().assertThat().statusCode(200).log().everything();
//		
//	}
	@Test
	public void LogibnToShopperStack() {
		HashMap data = new HashMap();
		data.put("email", "santhosh.ac@testyantra.com");
		data.put("password", "Santhosh13@");
		data.put("role", "SHOPPER");
		String response = RestAssured.given().body(data).contentType(ContentType.JSON).log().all().when()
				.post(baseUrl + "/users/login").then().assertThat().statusCode(200).log().all().extract().response()
				.asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		int userId = js.get("data.userId");
		String Token = js.get("data.jwtToken");
		System.out.println("userID=" + userId);
		System.out.println("Token=" + Token);

	}

}
