package com.vogame.controller;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.invitation.response.GetInvitationsByGameIdResponse;
import com.vogame.dto.invitation.response.GetInvitationsByHostUserIdResponse;
import com.vogame.dto.invitation.response.GetInvitationsByInviteeResponse;
import com.vogame.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @GetMapping("/getByHostUser/{userId}")
    public ResponseEntity<GetInvitationsByHostUserIdResponse> getByHostUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(invitationService.getByHostUserId(userId));
    }

    @GetMapping("/getByInvitee/{userId}")
    public ResponseEntity<GetInvitationsByInviteeResponse> getByInvitee(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(invitationService.getByInvitee(userId));
    }

    @PostMapping("/join/{userId}/{gameId}")
    public ResponseEntity<AbstractVogameResponse> joinToGame(@PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(invitationService.joinToGame(userId, gameId));
    }

    @GetMapping("/getByGameId/{gameId}")
    public ResponseEntity<GetInvitationsByGameIdResponse> getByGameId(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(invitationService.getByGameId(gameId));
    }

}
