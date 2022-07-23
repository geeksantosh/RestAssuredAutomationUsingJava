import io.restassured.path.json.JsonPath;

public class ReUsable {

    public static JsonPath rawToJson(String getResponse){
        JsonPath getAddress = new JsonPath(getResponse);
        return getAddress;
    }
}