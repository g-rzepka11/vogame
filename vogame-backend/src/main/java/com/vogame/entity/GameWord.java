package com.vogame.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(schema = "vogame", name = "game_word")
@Data
public class GameWord {

    @Id
    @Column
    private Long id;

    @Column
    private Long gameId;

    @Column
    private Long wordId;

    @Column
    private String status;

    @Column
    private Long userId;

    @Column
    private BigDecimal score;
}
