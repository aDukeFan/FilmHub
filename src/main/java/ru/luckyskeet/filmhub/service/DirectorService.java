package ru.luckyskeet.filmhub.service;

import ru.luckyskeet.filmhub.model.Director;

import java.util.List;

public interface DirectorService {

    Director create(Director director);

    Director update(Director director);

    Director getById(Integer id);

    List<Director> getAll();

    void removeById(Integer id);
}
