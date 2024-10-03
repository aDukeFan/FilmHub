package ru.luckyskeet.filmhub.service;

import ru.luckyskeet.filmhub.model.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    Rating update(Rating rating);

    Rating getById(int id);

    List<Rating> getAll();

    void remove(int id);
}
