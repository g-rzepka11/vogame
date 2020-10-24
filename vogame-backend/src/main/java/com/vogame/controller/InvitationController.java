package com.vogame.controller;

import com.vogame.dto.InvitationDTO;
import com.vogame.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @GetMapping("/getByHostUser/{userId}")
    public List<InvitationDTO> getByHostUserId(@PathVariable("userId") Long userId) {
        return invitationService.getByHostUserId(userId);
    }

    @GetMapping("/getByInvitee/{userId}")
    public List<InvitationDTO> getByInvitee(@PathVariable("userId") Long userId) {
        return invitationService.getByInvitee(userId);
    }

    @PostMapping("/join/{userId}/{gameId}")
    public void joinToGame(@PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId) {
        invitationService.joinToGame(userId, gameId);
    }

    @GetMapping("/getByGameId/{gameId}")
    public List<InvitationDTO> getByGameId(@PathVariable("gameId") Long gameId) {
        return invitationService.getByGameId(gameId);
    }

}
