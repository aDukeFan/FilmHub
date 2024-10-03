package ru.luckyskeet.filmhub.service;

import ru.luckyskeet.filmhub.model.Event;
import ru.luckyskeet.filmhub.model.Film;
import ru.luckyskeet.filmhub.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    User getById(int id);

    List<User> findAll();

    User addFollow(int userId, int friendId);

    User removeFollow(int userId, int friendId);

    List<User> getSameFriends(int userId, int friendId);

    List<User> getFriends(int userId);

    void delUserById(int userId);

    List<Film> getRecommendFilms(int userId);

    List<Event> getEventsByUserId(Integer id);
}
