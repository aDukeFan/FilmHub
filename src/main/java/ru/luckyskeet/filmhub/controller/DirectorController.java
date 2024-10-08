package ru.luckyskeet.filmhub.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.luckyskeet.filmhub.model.Director;
import ru.luckyskeet.filmhub.service.DirectorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/directors")
@AllArgsConstructor
public class DirectorController {

    private DirectorService service;

    @PostMapping
    public Director create(@Valid @RequestBody Director director) {
        return service.create(director);
    }

    @PutMapping
    public Director update(@Valid @RequestBody Director director) {
        return service.update(director);
    }

    @GetMapping("/{id}")
    public Director getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Director> findAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.removeById(id);
    }
}
