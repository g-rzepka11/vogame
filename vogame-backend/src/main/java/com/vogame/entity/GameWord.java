package com.vogame.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(schema = "vogame", name = "game_word")
public class GameWord {

    @Id
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    @OneToMany(mappedBy = "gameWord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameWordUserScore> gameWordUserScores;

    @ManyToOne(fetch = FetchType.LAZY)
    private Word word;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<GameWordUserScore> getGameWordUserScores() {
        return gameWordUserScores;
    }

    public void setGameWordUserScores(List<GameWordUserScore> gameWordUserScores) {
        this.gameWordUserScores = gameWordUserScores;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
