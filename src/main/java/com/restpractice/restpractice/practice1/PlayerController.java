package com.restpractice.restpractice.practice1;

import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome REST API";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/players/{id}")
    public Player getPlayerById(@PathVariable("id") int playerId) {
        return playerService.getPlayer(playerId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/players")
    public Player addPlayer(@RequestBody Player player, HttpServletRequest req) {
        System.out.println(req);
        try (InputStream inputStream = req.getInputStream()) {
            String json = IOUtils.toString(inputStream, Charset.defaultCharset());
            System.out.println(json);
        } catch (IOException e) {
            System.out.println("hi");
        }
        player.setId(0);
        return playerService.addPlayer(player);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/players/{id}")
    public Player updatePlayer(@PathVariable("id") int playerId, @RequestBody Player newPlayer) {
        return playerService.updatePlayer(playerId, newPlayer);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = "/players/{id}")
    public Player patchPlayer(@PathVariable("id") int playerId, @RequestBody Map<String, Object> playerPatch) {
        return playerService.patchPlayer(playerId, playerPatch);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/players/{id}")
    public String deletePlayer(@PathVariable("id") int playerId) {
        return playerService.deletePlayer(playerId);
    }
}
