import files.Payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MyFirstAPIAutomation {

    public static void main(String[] args) {

        //Validate if Add place API is working as expected

        //Given - all input details
        //When - Submit the API - Resource, http method
        //Then - Validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.41 (Ubuntu)");

//        Add place-> Update place with new Address -> Get place validate if New address is present in response



    }
}
