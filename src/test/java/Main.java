import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Main {

    public static void main(String[] args) {

        //Validate if Add place API is working as expected

        //Given - all input details
        //When - Submit the API - Resource, http method
        //Then - Validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println("Response is: " + response);
        JsonPath postResponse = ReUsable.rawToJson(response);
        String placeId = postResponse.getString("place_id"); //Extracting Place_id value

        System.out.println("Place Id is: " + placeId); //Printing placeId
        String newAddress = "Hetauda, Nepal";


//        Add place-> Update place with new Address -> Get place validate if New address is present in response
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.updatePlace(placeId, newAddress))
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get place
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        JsonPath getAddress = ReUsable.rawToJson(getPlaceResponse);
        String actualAddress = getAddress.getString("address");
        System.out.println("Actual Address: " + actualAddress);
        Assert.assertEquals(actualAddress, newAddress);
    }
}