package com.vogame.controller;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.learn.LearnConfigDTO;
import com.vogame.dto.learn.SaveLearnUserWordsRequest;
import com.vogame.dto.learn.response.*;
import com.vogame.exception.LearnUserNotExistsException;
import com.vogame.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private LearnService learnService;

    @PostMapping("/save")
    public ResponseEntity<SaveLearnUserWordResponse> saveLearnUserWord(@RequestBody SaveLearnUserWordsRequest saveLearnUserWordsRequest) {
        return ResponseEntity.ok(learnService.save(saveLearnUserWordsRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AbstractVogameResponse> deleteLearnUserWord(@PathVariable("id") Long id) {
        return ResponseEntity.ok(learnService.delete(id));
    }

    @PostMapping("/startLearning/{userId}")
    public ResponseEntity<StartLearningResponse> startLearning(@PathVariable Long userId) {
        return ResponseEntity.ok(learnService.startLearning(userId));
    }

    @PostMapping("/startLearning/reverse/{userId}")
    public ResponseEntity<StartLearningResponse> reverseStartLearning(@PathVariable Long userId) {
        return ResponseEntity.ok(learnService.reverseStartLearning(userId));
    }

    @PostMapping("/know/{learnUserWordId}")
    public ResponseEntity<AbstractVogameResponse> know(@PathVariable Long learnUserWordId) {
        return ResponseEntity.ok(learnService.know(learnUserWordId));
    }

    @PostMapping("/know/reverse/{learnUserWordId}")
    public ResponseEntity<AbstractVogameResponse> reverseKnow(@PathVariable Long learnUserWordId) {
        return ResponseEntity.ok(learnService.reverseKnow(learnUserWordId));
    }

    @PostMapping("/dontKnow/{learnUserWordId}")
    public ResponseEntity<AbstractVogameResponse> dontKnow(@PathVariable Long learnUserWordId) {
        return ResponseEntity.ok(learnService.dontKnow(learnUserWordId));
    }

    @PostMapping("/dontKnow/reverse/{learnUserWordId}")
    public ResponseEntity<AbstractVogameResponse> reverseDontKnow(@PathVariable Long learnUserWordId) {
        return ResponseEntity.ok(learnService.reverseDontKnow(learnUserWordId));
    }

    @GetMapping("/stats/{userId}")
    public ResponseEntity<GetLearnStatsResponse> stats(@PathVariable Long userId) {
        return ResponseEntity.ok(learnService.getStats(userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<GetLearnUserWordsPageResponse> getByUserIdPage(@PathVariable("userId") Long userId, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        return ResponseEntity.ok(learnService.getByUserId(userId, pageNumber));
    }

    @GetMapping("/user/{userId}/config")
    public ResponseEntity<GetLearnConfigResponse> getConfig(@PathVariable("userId") Long userId) throws LearnUserNotExistsException {
        return ResponseEntity.ok(learnService.getConfig(userId));
    }

    @PostMapping("/user/{userId}/config")
    public ResponseEntity<AbstractVogameResponse> saveConfig(@PathVariable("userId") Long userId, @RequestBody LearnConfigDTO learnConfigDTO) throws LearnUserNotExistsException {
        return ResponseEntity.ok(learnService.saveConfig(userId, learnConfigDTO));
    }
}
