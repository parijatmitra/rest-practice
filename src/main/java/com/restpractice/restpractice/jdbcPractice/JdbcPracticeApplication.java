package com.restpractice.restpractice.jdbcPractice;


import com.restpractice.restpractice.jdbcPractice.model.Player;
import com.restpractice.restpractice.jdbcPractice.repository.PlayerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Date;


@SpringBootApplication
public class JdbcPracticeApplication implements CommandLineRunner {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerDao playerDao;
    public static void main(String[] args) {
        SpringApplication.run(JdbcPracticeApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
       logger.info("Check list {}", playerDao.getAllPlayers());
       logger.info("Player by id {}", playerDao.getPlayerById(1));
       playerDao.insertPlayer(new Player(4, "Player5", "Indian", new Date(System.currentTimeMillis()), 19));
       logger.info("{}", playerDao.getAllPlayers());
       playerDao.updatePlayer(new Player(4, "Parijat", "American-Indian", new Date(System.currentTimeMillis()), 19));
       logger.info("{}", playerDao.getPlayerById(4));
       playerDao.deletePlayer(2);
       logger.info("{}", playerDao.getAllPlayers());
       playerDao.createTournamentTable();
    }
}
