package com.vogame.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "vogame", name = "invitation")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hostUser;

    @OneToOne
    private User invitee;

    @OneToOne
    private Game game;

    @Column(updatable = false)
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

    public User getInvitee() {
        return invitee;
    }

    public void setInvitee(User invitee) {
        this.invitee = invitee;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
