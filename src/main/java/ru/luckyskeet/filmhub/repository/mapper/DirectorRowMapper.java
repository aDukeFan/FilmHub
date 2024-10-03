package ru.luckyskeet.filmhub.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.luckyskeet.filmhub.model.Director;

@Component
public class DirectorRowMapper {

    public RowMapper<Director> getMapper() {
        return (rs, rowNum) -> new Director()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"));
    }
}
