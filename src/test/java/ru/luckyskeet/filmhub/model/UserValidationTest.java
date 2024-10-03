package ru.luckyskeet.filmhub.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserValidationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private static Stream<User> provideInvalidUsers() {
        return Stream.of(
                new User() // Неправильный email
                        .setLogin("thirdGay")
                        .setEmail("yyayayaya")
                        .setBirthday(LocalDate.of(2000, 1, 1)),

                new User() // Неправильная дата рождения
                        .setLogin("forthGay")
                        .setBirthday(LocalDate.now()) // Нельзя использовать текущую дату
                        .setEmail("forthGay@ya.ru"),

                new User() // Неправильный логин (с пробелом)
                        .setLogin("firth Gay")
                        .setEmail("ohohoho@ya.ru")
                        .setBirthday(LocalDate.of(2000, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidUsers")
    @DisplayName("Should throw validation exceptions for invalid users")
    public void shouldThrowValidationExceptions(User invalidUser) {
        Set<ConstraintViolation<User>> violations = validator.validate(invalidUser);
        assertFalse(violations.isEmpty(), "User validation should fail for invalid user data");
    }
}
