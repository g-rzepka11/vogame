package com.vogame.dto;

import java.util.Date;

public class InvitationDTO {

    private Long id;

    private Long hostUser;

    private UserDTO invitee;

    private GameRawDTO game;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostUser() {
        return hostUser;
    }

    public void setHostUser(Long hostUser) {
        this.hostUser = hostUser;
    }

    public UserDTO getInvitee() {
        return invitee;
    }

    public void setInvitee(UserDTO invitee) {
        this.invitee = invitee;
    }

    public GameRawDTO getGame() {
        return game;
    }

    public void setGame(GameRawDTO game) {
        this.game = game;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
