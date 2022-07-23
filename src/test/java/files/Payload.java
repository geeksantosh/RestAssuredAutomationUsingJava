package files;

public class Payload {
    public static String addPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"GeekWorld\",\n" +
                "  \"phone_number\": \"(+91) 363 363 3636\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://testing.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String updatePlace(String placeId, String newAddress) {
        return "{\n" +
                "    \"place_id\":\"" + placeId + "\",\n" +
                "    \"address\":\"" + newAddress + "\",\n" +
                "    \"key\":\"qaclick123\"\n" +
                "}";
    }
}