package com.vogame.controller;

import com.vogame.dto.LearnUserWordDTO;
import com.vogame.dto.SaveLearnUserWordsRequest;
import com.vogame.service.LearnUserWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learn")
public class LearnUserWordController {

    @Autowired
    private LearnUserWordService learnUserWordService;

    @GetMapping("/user/{userId}")
    public List<LearnUserWordDTO> getByUserId(@PathVariable("userId") Long userId) {
        return learnUserWordService.getByUserId(userId);
    }

    @PostMapping("/save")
    public LearnUserWordDTO saveLearnUserWord(@RequestBody SaveLearnUserWordsRequest saveLearnUserWordsRequest) {
        return learnUserWordService.save(saveLearnUserWordsRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLearnUserWord(@PathVariable("id") Long id) {
        learnUserWordService.delete(id);
    }

}
