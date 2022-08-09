import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.given;

public class JiraTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:8080/";
        SessionFilter session = new SessionFilter();
        String response = given().header("Content-Type", "application/json").body("{ \n" +
                "    \"username\": \"Geeksantosh\", \n" +
                "    \"password\": \"S@nut0sh@\" \n" +
                "}").log().all().filter(session).when().post("rest/auth/1/session").then().log().all().extract().response().asString();


        given().pathParam("key", "GEEK-10").log().all().header("Content-Type", "application/json").body("{\n" +
                "    \"body\": \"This is my first comment.\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").filter(session).when().post("rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201);


    }


}
