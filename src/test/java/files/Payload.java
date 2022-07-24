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

    public static String coursePrice() {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 2182,\n" +
                "    \"website\": \"studywholenight.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"SQL\",\n" +
                "      \"price\": 18,\n" +
                "      \"copies\": 14\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cucumber BDD\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"JAVA Advance\",\n" +
                "      \"price\": 35,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Python\",\n" +
                "      \"price\": 22,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}