package com.vogame.controller;

import com.vogame.dto.*;
import com.vogame.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private LearnService learnService;

    @PostMapping("/save")
    public LearnUserWordDTO saveLearnUserWord(@RequestBody SaveLearnUserWordsRequest saveLearnUserWordsRequest) {
        return learnService.save(saveLearnUserWordsRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLearnUserWord(@PathVariable("id") Long id) {
        learnService.delete(id);
    }

    @PostMapping("/startLearning/{userId}")
    public List<LearnUserWordDTO> startLearning(@PathVariable Long userId) {
        return learnService.startLearning(userId);
    }

    @PostMapping("/know/{learnUserWordId}")
    public void know(@PathVariable Long learnUserWordId) {
        learnService.know(learnUserWordId);
    }

    @PostMapping("/dontKnow/{learnUserWordId}")
    public void dontKnow(@PathVariable Long learnUserWordId) {
        learnService.dontKnow(learnUserWordId);
    }

    @GetMapping("/stats/{userId}")
    public LearnStatsDTO stats(@PathVariable Long userId) {
        return learnService.getStats(userId);
    }

    @GetMapping("/user/{userId}")
    public LearnUserWordsPageResponse getByUserIdPage(@PathVariable("userId") Long userId, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        return learnService.getByUserId(userId, pageNumber);
    }

    @GetMapping("/user/{userId}/config")
    public LearnConfigDTO getConfig(@PathVariable("userId") Long userId) {
        return learnService.getConfig(userId);
    }

    @PostMapping("/user/{userId}/config")
    public void saveConfig(@PathVariable("userId") Long userId, @RequestBody LearnConfigDTO learnConfigDTO) {
        learnService.saveConfig(userId, learnConfigDTO);
    }
}
