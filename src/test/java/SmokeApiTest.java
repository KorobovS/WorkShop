import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTest {

    String body = "{" +
            "\"id\": 3,\n" +
            "\"username\": \"Vasya\",\n" +
            "\"firstName\": \"Ivanovich\",\n" +
            "\"lastName\": \"Ivanov\",\n" +
            "\"email\": \"mail@email.ru\",\n" +
            "\"password\": \"FQsfxhgf\",\n" +
            "\"phone\": \"1234567890\",\n" +
            "\"userStatus\": 1\n" +
            "}";

    @Test
    public void testSimple() {
        JsonPath responseJson = given()
                    .headers("accept", "application/json")
                    .headers("Content-Type", "application/json")
                    .baseUri("https://petstore.swagger.io/v2/")
                .when()
                    .body(body)
                    .post("user")
                    .getBody().jsonPath();

        String message = responseJson.getString("message");

        Assertions.assertEquals(200, responseJson.getInt("code"));
        Assertions.assertEquals("unknown", responseJson.getString("type"));
        Assertions.assertTrue(
                message.matches("\\d+"),
                "Message содержит не только цифры");
        Assertions.assertEquals(1, message.length());
    }
}
