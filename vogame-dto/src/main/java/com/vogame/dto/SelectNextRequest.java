package com.vogame.dto;

public class SelectNextRequest {
    private Long gameId;
    private Long userId;
    private Long wordId;

    public SelectNextRequest() {
    }

    public SelectNextRequest(Long gameId, Long userId, Long wordId) {
        this.gameId = gameId;
        this.userId = userId;
        this.wordId = wordId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }
}
