package demo;

import java.util.HashMap;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TekarchAPiTesting1 {

	public static void main(String[] args) {
		
			RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
			//content-type - header
			//Userid,password - payload
			//method - POST
			
			/*HashMap<String,String> headers = new HashMap<String,String>();
			headers.put("Content-Type",ContentType.JSON.toString());
			Response res = RestAssured.given().headers(headers).when()
			.body("{\"username\": \"mar2023pravalika@ta.com\", \"password\": \"Mar231234\"}")
			.post().then().statusCode(201).extract().response();*/
			
			//or
			
			
			Response res = RestAssured.given().header("Content-Type",ContentType.JSON.toString()).when()
					.body("{\"username\": \"mar2023pravalika@ta.com\", \"password\": \"Mar231234\"}").post("login");
			
			//or
			
			//Response res = RestAssured.given().contentType(ContentType.JSON).when()
			//.body("{\"username\": \"mar2023pravalika@ta.com\", \"password\": \"Mar231234\"}").post();	
			
//			JsonObject joHeaders = new JsonObject();
//			joHeaders.addProperty("Content-Type","appilication/json");
			
			System.out.println(res.asPrettyString());
			
			String token = res.jsonPath().getString("token").replaceAll("\\[", "").replaceAll("]", "");
			System.out.println(token);
			
			
			// no need    RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData";
			HashMap<String,String> addDataHeaders = new HashMap<String,String>();
			addDataHeaders.put("Content-Type",ContentType.JSON.toString());
			addDataHeaders.put("token", token);
			
			//String payload = "{\"accountno\": \"TA-5432171\", \"departmentno\": \"7\", \"salary\": \"123499\", \"pincode\": \"123767\"}";
			
			HashMap<String,String> addDataPayload = new HashMap<String,String>();
			addDataPayload.put("accountno","TA-5432171");
			addDataPayload.put("departmentno","7");
			addDataPayload.put("salary","123499");
			addDataPayload.put("pincode","123767");
			
			Response res2 = RestAssured.given().headers(addDataHeaders).when()
					.body(addDataPayload)
					.post("addData").then().statusCode(201).extract().response();
			System.out.println(res2.asPrettyString());
					
	}
}
