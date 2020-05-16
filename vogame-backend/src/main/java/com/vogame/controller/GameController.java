package com.vogame.controller;

import com.vogame.dto.GameDTO;
import com.vogame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/getByOwnerId/{ownerId}")
    public List<GameDTO> getGameByOwnerId(@PathVariable("ownerId") Long ownerId) {
        return gameService.getGameByOwnerId(ownerId);
    }

    @GetMapping("/id/{id}")
    public GameDTO getGameById(@PathVariable("id") Long id) {
        return gameService.getGameById(id);
    }
}
