package com.vogame.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vogame", name = "game_user")
@Data
public class GameUser {

    @Id
    @Column
    private Long id;

    @Column
    private Long gameId;

    @Column
    private Long userId;

    @Column
    private Boolean moderator;
}
