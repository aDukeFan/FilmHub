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

public class FilmValidationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private static Stream<Film> provideInvalidFilms() {
        String longDescription = "i".repeat(201);

        return Stream.of(
                // Дата релиза — не раньше 28 декабря 1895 года
                new Film()
                        .setName("Public Enemies")
                        .setDescription("about public enemies")
                        .setReleaseDate(LocalDate.of(1895, 12, 27)) // Ошибка: раньше допустимой даты
                        .setDuration(200),

                // Название не может быть пустым
                new Film()
                        .setName(null) // Ошибка: название пустое
                        .setDescription("about gangsters")
                        .setReleaseDate(LocalDate.of(1999, 12, 28))
                        .setDuration(200),

                // Продолжительность фильма должна быть положительной
                new Film()
                        .setName("Public Enemies")
                        .setDescription("about public enemies")
                        .setReleaseDate(LocalDate.of(1999, 12, 28))
                        .setDuration(-200), // Ошибка: отрицательная продолжительность

                // Максимальная длина описания — 200 символов
                new Film()
                        .setName("Public Enemies")
                        .setDescription(longDescription) // Ошибка: длина описания больше 200 символов
                        .setReleaseDate(LocalDate.of(1985, 12, 28))
                        .setDuration(200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidFilms")
    @DisplayName("Should throw validation exceptions for invalid films")
    public void shouldNotPassValidation(Film invalidFilm) {
        Set<ConstraintViolation<Film>> violations = validator.validate(invalidFilm);
        assertFalse(violations.isEmpty(), "Film validation should fail for invalid film data");
    }
}
