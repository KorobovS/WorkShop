import controllers.UserController;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.AddUserResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static testData.TestData.DEFAULT_USER;
import static testData.TestData.INVALID_USER;

@Story("API tests")
public class ApiTest {

    UserController userController = new UserController();

    @Test
    void testCreateUserController() {

        Response response = userController.createUser(DEFAULT_USER);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertFalse(createUserResponse.getMessage().isEmpty());
        Assertions.assertEquals(DEFAULT_USER.getId() + "", createUserResponse.getMessage());
    }

    static Stream<User> users() {
        return Stream.of(INVALID_USER, DEFAULT_USER);
    }

    @ParameterizedTest
    @MethodSource("users")
    void testCreateUserParametrized(User user) {

        Response response = userController.createUser(user);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertFalse(createUserResponse.getMessage().isEmpty());
        Assertions.assertEquals(user.getId() + "", createUserResponse.getMessage());
    }
}

