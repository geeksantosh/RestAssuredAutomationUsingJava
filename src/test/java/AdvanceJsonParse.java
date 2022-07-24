import files.Payload;
import io.restassured.path.json.JsonPath;

public class AdvanceJsonParse {
    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
        //        1. Print No of courses returned by API
        int courseCount = jsonPath.getInt("courses.size()");
        System.out.println("Total Present course number: " + courseCount);

        //        2.Print Purchase Amount
        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("Total Amount is: " + totalAmount);

        //        3. Print Title of the first course
        String courseTitleOfFirstCourse = jsonPath.get("courses[2].title");
        System.out.println("First Course Name: " + courseTitleOfFirstCourse);

        //        4. Print All course titles and their respective Prices
        for (int i = 0; i < courseCount; i++) {
            String allCourseTitles = jsonPath.get("courses[" + i + "].title");
            int allCoursePrice = jsonPath.get("courses[" + i + "].price");
            System.out.println("Course Prices and Title");
            System.out.println(allCourseTitles);
            System.out.println(allCoursePrice);
        }

        //        5. Print no of copies sold by RPA Course
        System.out.println("Total copies sold by RPA course");
        for (int i = 0; i < courseCount; i++) {
            String courseTitle = jsonPath.get("courses[" + i + "].title");
            if (courseTitle.equalsIgnoreCase("RPA")) {
                //Copies sold by RPA
                int copiesSold = jsonPath.get("courses[" + i + "].copies");
                System.out.println(courseTitle + ": " + copiesSold);
                break;
            }
        }

        // Print price of all courses
        System.out.println("----------------Print Prices of all courses and Copies----------------");
        for (int i = 0; i < courseCount; i++) {
            String courseTitle = jsonPath.get("courses[" + i + "].title");
            int coursePrice = jsonPath.get("courses[" + i + "].price");
            int courseSoldCopies = jsonPath.get("courses[" + i + "].copies");
            System.out.println("Course Name: " + courseTitle + " \nCourse Price: " + coursePrice + " \nSold Copies: " + courseSoldCopies + "\n------------");
        }

        //        6. Verify if Sum of all Course prices matches with Purchase Amount



    }
}