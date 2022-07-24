import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.*;

public class validateTotalAmount {

    @Test
    public void sumOfCourses() {
        int totalsum = 0;
        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
        int count = jsonPath.getInt("courses.size()");
        for (int i = 0; i < count; i++) {
            int price = jsonPath.get("courses[" + i + "].price");
            int soldCopies = jsonPath.get("courses[" + i + "].copies");
            int totalAmount = price * soldCopies;
            System.out.println(totalAmount);
            totalsum = totalAmount + totalsum;
        }
        int totalPurchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        Assert.assertEquals(totalPurchaseAmount, totalsum);
    }

}