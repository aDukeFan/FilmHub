package ru.luckyskeet.filmhub.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.luckyskeet.filmhub.model.Genre;

@Component
public class GenreRowMapper {

    public RowMapper<Genre> getMapper() {
        return (rs, rowNum) -> new Genre()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"));
    }
}
