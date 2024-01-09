package com.restpractice.restpractice.practice1;

import com.restpractice.restpractice.practice1.errorHandling.PlayerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id) {
        //Player p = playerRepository.findById(id);
        Optional<Player>playerOptional = playerRepository.findById(id);
        Player p = null;
        if(playerOptional.isPresent()) {
            p = playerOptional.get();
        } else {
            logger.info("Player with id = {} not found", id);
           // throw new RuntimeException("Player with id=" + id + " is not found (Runtime Exception)");
            throw new PlayerNotFoundException("Player with id= " + id + " is not found");
        }
        return p;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(int playerId, Player newPlayer) {
        Optional<Player>playerOptional = playerRepository.findById(playerId);
        if(playerOptional.isEmpty()) {
            throw new RuntimeException("Update Id=" + playerId + " is not found");
        }
        newPlayer.setId(playerId);
        return playerRepository.save(newPlayer);
    }

    public Player patchPlayer(int playerId, Map<String, Object> playerPatch) {
        Optional<Player>playerOptional = playerRepository.findById(playerId);
        if(playerOptional.isEmpty()) {
            throw new RuntimeException("Player with id=" + playerId  + " is not found (Runtime Exception");
        }
        Player newPatchedPlayer = playerOptional.get();
        playerPatch.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Player.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, newPatchedPlayer, value);
        });
        return playerRepository.save(newPatchedPlayer);
    }

    public String deletePlayer(int playerId) {
       Optional<Player>playerOptional = playerRepository.findById(playerId);
       if(playerOptional.isEmpty()) {
           return "Player with id=" + playerId + " is already deleted or is not there";
       }
       Player cur = playerOptional.get();
       playerRepository.delete(cur);
       return "Player with id=" + playerId + " is deleted";
    }
}
