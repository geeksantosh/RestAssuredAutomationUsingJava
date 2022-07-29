import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(dataProvider = "BookData")
    public void addBook(String bookName, String isbn, String author, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
                .body(Payload.addBook(bookName, isbn, author, aisle))
                .when()
                .post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = ReUsable.rawToJson(response);
        String id = jsonPath.get("ID");
        System.out.println(id);

        //deleteBook


    }

    @DataProvider(name = "BookData")
    public Object[][] getData() {
        return new Object[][]{{"C++", "3636", "San Ad", "cplus"},
                {"Computer Graphics", "1548", "San Ad", "CG"}, {"Dot Net", "3636", "San Ad", "dotnet"}};

    }

}
