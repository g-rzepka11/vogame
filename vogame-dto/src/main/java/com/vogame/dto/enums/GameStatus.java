package com.vogame.dto.enums;

public enum GameStatus {
    NOT_STARTED(0),
    ACTION(1),
    SELECT(2),
    FINISHED(3);

    private int statusId;

    GameStatus(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public static GameStatus getByStatusId(int statusId) {
        for(GameStatus gameStatus : GameStatus.values()) {
            if(gameStatus.statusId == statusId) {
                return gameStatus;
            }
        }
        return null;
    }
}
