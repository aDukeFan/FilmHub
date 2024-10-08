package ru.luckyskeet.filmhub.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.luckyskeet.filmhub.model.Rating;
import ru.luckyskeet.filmhub.repository.RatingRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.create(rating);
    }

    @Override
    public Rating update(Rating rating) {
        return repository.update(rating);
    }

    @Override
    public Rating getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Rating> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(int id) {
        repository.removeById(id);

    }
}
