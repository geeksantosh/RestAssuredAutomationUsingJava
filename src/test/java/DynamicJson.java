import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json").body(Payload.addBook())
                .when()
                .post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = ReUsable.rawToJson(response);
        String id = jsonPath.get("ID");
        System.out.println(id);
    }

}
