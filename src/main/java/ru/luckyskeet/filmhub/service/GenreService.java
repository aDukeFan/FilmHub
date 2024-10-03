package ru.luckyskeet.filmhub.service;

import ru.luckyskeet.filmhub.model.Genre;

import java.util.List;

public interface GenreService {

    Genre create(Genre genre);

    Genre update(Genre genre);

    Genre getById(int id);

    List<Genre> getAll();

    void remove(int id);
}
