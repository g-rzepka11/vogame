package com.vogame.controllers;

import com.vogame.beans.CheckWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    private CounterController counterController;

    @MessageMapping("/check")
    public void check(CheckWord message) throws Exception {
        if(counterController.getCurrentWord().equals(message.getWord())) {
            counterController.success();
        }
    }
}