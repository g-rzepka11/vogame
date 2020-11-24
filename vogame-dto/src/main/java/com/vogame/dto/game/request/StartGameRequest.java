package com.vogame.dto.game.request;

public class StartGameRequest {
    private Long userId;
    private Long gameId;

    public StartGameRequest() {
    }

    public StartGameRequest(Long userId, Long gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
