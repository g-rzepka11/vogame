package com.vogame.dto;

import com.vogame.dto.word.WordDTO;

import java.util.List;

public class GameWordDTO {
    private Long id;
    private Long gameId;
    private List<GameWordUserScoreDTO> gameWordUserScores;
    private WordDTO word;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<GameWordUserScoreDTO> getGameWordUserScores() {
        return gameWordUserScores;
    }

    public void setGameWordUserScores(List<GameWordUserScoreDTO> gameWordUserScores) {
        this.gameWordUserScores = gameWordUserScores;
    }

    public WordDTO getWord() {
        return word;
    }

    public void setWord(WordDTO word) {
        this.word = word;
    }
}
