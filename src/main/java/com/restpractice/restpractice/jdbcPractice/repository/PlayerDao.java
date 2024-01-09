package com.restpractice.restpractice.jdbcPractice.repository;

import com.restpractice.restpractice.jdbcPractice.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM Player";
        return jdbcTemplate.query(sql, new PlayerMapper());
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM Player WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new PlayerMapper(), id);
    }

    public int insertPlayer(Player player) {
        String sql = "INSERT INTO Player (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, player.getId(), player.getName(), player.getNationality(), player.getBirthDate(), player.getTitles());

    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE Player SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, player.getName(), player.getNationality(), player.getBirthDate(), player.getTitles(), player.getId());
    }

    public int deletePlayer(int playerId) {
        String sql = "DELETE FROM Player WHERE ID = ?";
        return jdbcTemplate.update(sql, playerId);
    }

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (\n" +
                "  ID INTEGER NOT NULL,\n" +
                "  NAME VARCHAR(30),\n" +
                "  LOCATION VARCHAR(50),\n" +
                "  PRIMARY KEY (ID)\n" +
                ")";
        jdbcTemplate.execute(sql);
    }
}
