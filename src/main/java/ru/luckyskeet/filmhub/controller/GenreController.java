package ru.luckyskeet.filmhub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.luckyskeet.filmhub.model.Genre;
import ru.luckyskeet.filmhub.service.GenreService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/genres")
public class GenreController {

    private GenreService service;

    @PostMapping
    public Genre create(@Valid @RequestBody Genre genre) {
        return service.create(genre);
    }

    @PutMapping
    public Genre update(@Valid @RequestBody Genre genre) {
        return service.update(genre);
    }

    @GetMapping("{id}")
    public Genre getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping()
    public List<Genre> getAll() {
        return service.getAll();
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable int id) {
        service.remove(id);
    }
}
