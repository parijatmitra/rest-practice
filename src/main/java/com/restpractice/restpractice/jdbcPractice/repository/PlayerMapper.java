package com.restpractice.restpractice.jdbcPractice.repository;

import com.restpractice.restpractice.jdbcPractice.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class PlayerMapper implements RowMapper<Player> {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
       Player player = new Player();
       player.setId(rs.getInt("ID"));
       player.setName(rs.getString("NAME"));
       player.setNationality(rs.getString("Nationality"));
       player.setBirthDate(rs.getTimestamp("Birth_date"));
       player.setTitles(rs.getInt("Titles"));
       return player;
    }
}
