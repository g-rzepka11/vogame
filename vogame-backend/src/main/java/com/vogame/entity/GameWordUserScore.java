package com.vogame.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(schema = "vogame", name = "game_word_user_score")
public class GameWordUserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private GameWord gameWord;

    @Column
    private Long userId;

    @Column
    private BigDecimal score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameWord getGameWord() {
        return gameWord;
    }

    public void setGameWord(GameWord gameWord) {
        this.gameWord = gameWord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
