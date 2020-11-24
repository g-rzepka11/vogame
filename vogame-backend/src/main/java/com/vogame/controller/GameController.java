package com.vogame.controller;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.game.request.CreateNewGameRequest;
import com.vogame.dto.game.request.SelectNextRequest;
import com.vogame.dto.game.request.StartGameRequest;
import com.vogame.dto.game.response.*;
import com.vogame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<GetGameByUserIdResponse> getGameByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(gameService.getGameByUserId(userId));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GetGameByIdResponse> getGameById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @PostMapping("/updatehash/id/{id}")
    public ResponseEntity<GameUpdateHashResponse> updateHash(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gameService.updateHash(id));
    }

    @PostMapping("/updateDateAndHash/id/{id}")
    public ResponseEntity<GameUpdateDateAndHashResponse> updateDateAndHash(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gameService.updateDateAndHash(id));
    }

    @PostMapping("/wordguessed/id/{id}")
    public ResponseEntity<GameWordGuessedResponse> wordGuessed(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gameService.wordGuessed(id));
    }

    @PostMapping("/selectnext")
    public ResponseEntity<GameSelectNextResponse> selectNext(@RequestBody SelectNextRequest request){
        return ResponseEntity.ok(gameService.selectNext(request));
    }

    @PostMapping("/createNew")
    public ResponseEntity<CreateNewGameResponse> createNewGame(@RequestBody CreateNewGameRequest request) {
        return ResponseEntity.ok(gameService.createNewGame(request));
    }

    @PostMapping("/startGame")
    public ResponseEntity<AbstractVogameResponse> startGame(@RequestBody StartGameRequest startGameRequest) {
        return ResponseEntity.ok(gameService.startGame(startGameRequest));
    }
}
