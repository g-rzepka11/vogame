package com.vogame.controller;

import com.vogame.dto.LearnUserWordDTO;
import com.vogame.service.LearnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/learnUser")
public class LearnUserController {

    @Autowired
    private LearnUserService learnUserService;

    @PostMapping("/startLearning/{userId}")
    public List<LearnUserWordDTO> startLearning(@PathVariable Long userId) {
        return learnUserService.startLearning(userId);
    }

    @PostMapping("/know/{learnUserWordId}")
    public void know(@PathVariable Long learnUserWordId) {
        learnUserService.know(learnUserWordId);
    }

    @PostMapping("/dontKnow/{learnUserWordId}")
    public void dontKnow(@PathVariable Long learnUserWordId) {
        learnUserService.dontKnow(learnUserWordId);
    }

}
