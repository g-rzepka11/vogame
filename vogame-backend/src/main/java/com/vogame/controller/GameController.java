package com.vogame.controller;

import com.vogame.dto.*;
import com.vogame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/getByUserId/{userId}")
    public List<GameDTO> getGameByUserId(@PathVariable("userId") Long userId) {
        return gameService.getGameByUserId(userId);
    }

    @GetMapping("/id/{id}")
    public GameDTO getGameById(@PathVariable("id") Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/updatehash/id/{id}")
    public GameDTO updateHash(@PathVariable("id") Long id) {
        return gameService.updateHash(id);
    }

    @PostMapping("/updateDateAndHash/id/{id}")
    public GameDTO updateDateAndHash(@PathVariable("id") Long id) {
        return gameService.updateDateAndHash(id);
    }

    @PostMapping("/checkword")
    public void checkWord(@RequestBody CheckWordRequest checkWordRequest) {
        gameService.checkWord(checkWordRequest);
    }

    @PostMapping("/wordguessed/id/{id}")
    public GameDTO wordGuessed(@PathVariable("id") Long id) {
        return gameService.wordGuessed(id);
    }

    @PostMapping("/selectnext")
    public GameDTO selectNext(@RequestBody SelectNextRequest request){
        return gameService.selectNext(request);
    }

    @PostMapping("/createNew")
    public Long createNewGame(@RequestBody CreateNewGameRequest request) {
        return gameService.createNewGame(request);
    }

    @PostMapping("/startGame")
    public void startGame(@RequestBody StartGameRequest startGameRequest) {
        gameService.startGame(startGameRequest);
    }
}
