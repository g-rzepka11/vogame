package com.vogame.service;

import com.vogame.dto.InvitationDTO;
import com.vogame.entity.Game;
import com.vogame.entity.GameUser;
import com.vogame.entity.Invitation;
import com.vogame.repository.GameRepository;
import com.vogame.repository.InvitationRepository;
import com.vogame.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvitationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public List<InvitationDTO> getByHostUserId(Long userId) {
        return invitationRepository.findByHostUser(userId).stream()
                .map(invitation -> modelMapper.map(invitation, InvitationDTO.class))
                .collect(Collectors.toList());
    }

    public List<InvitationDTO> getByInvitee(Long userId) {
        return invitationRepository.findByInvitee_Id(userId).stream()
                .map(invitation -> modelMapper.map(invitation, InvitationDTO.class))
                .collect(Collectors.toList());
    }

    public void joinToGame(Long userId, Long gameId) {
        gameRepository.findById(gameId)
                .ifPresent(game -> addUserIdToGame(game, userId));
    }

    private void addUserIdToGame(Game game, Long userId) {
        boolean userIsPresentInGame = game.getGameUsers().stream()
                .anyMatch(gu -> gu.getUser().getId().equals(userId));
        if(userIsPresentInGame) {
            throw new RuntimeException("User: " + userId + " is present in game: " + game.getId());
        } else {
            userRepository.findById(userId).ifPresent(user -> {
                GameUser gameUser = new GameUser();
                gameUser.setGame(game);
                gameUser.setUser(user);
                gameUser.setModerator(false);
                game.getGameUsers().add(gameUser);
                gameRepository.save(game);
                deleteInvitation(game.getId(), userId);
            });
        }
    }

    private void deleteInvitation(Long gameId, Long userId) {
        List<Invitation> invitations = invitationRepository.findByInvitee_IdAndGame_Id(userId, gameId);
        invitationRepository.deleteAll(invitations);
    }

    public List<InvitationDTO> getByGameId(Long gameId) {
        return invitationRepository.findByGame_Id(gameId).stream()
                .map(invitation -> modelMapper.map(invitation, InvitationDTO.class))
                .collect(Collectors.toList());
    }
}
