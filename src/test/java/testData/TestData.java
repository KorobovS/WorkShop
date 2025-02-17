package testData;

import models.User;

public class TestData {

    public static final User DEFAULT_USER = User.builder()
            .id(1)
            .username("username")
            .firstName("firstName")
            .lastName("lastName")
            .email("email")
            .password("password")
            .phone("phone")
            .userStatus(0)
            .build();

    public static final User INVALID_USER = User.builder().build();
}
