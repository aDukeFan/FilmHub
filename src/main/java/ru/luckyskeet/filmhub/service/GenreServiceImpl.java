package ru.luckyskeet.filmhub.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.luckyskeet.filmhub.model.Genre;
import ru.luckyskeet.filmhub.repository.GenreRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private GenreRepository repository;

    @Override
    public Genre create(Genre genre) {
        return repository.create(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return repository.update(genre);
    }

    @Override
    public Genre getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(int id) {
        repository.removeById(id);

    }
}
