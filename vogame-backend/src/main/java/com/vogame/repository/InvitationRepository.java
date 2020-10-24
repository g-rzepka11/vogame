package com.vogame.repository;

import com.vogame.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    public List<Invitation> findByHostUser(Long hostUser);

    public List<Invitation> findByInvitee_Id(Long invitee);

    public List<Invitation> findByGame_Id(Long gameId);

    public List<Invitation> findByInvitee_IdAndGame_Id(Long invitee, Long gameId);

    public void deleteAllByGame_Id(Long gameId);
}
