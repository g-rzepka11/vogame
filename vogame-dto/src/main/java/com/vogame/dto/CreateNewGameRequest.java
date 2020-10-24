package com.vogame.dto;

import java.util.List;

public class CreateNewGameRequest {
    private String gameName;
    private Long userId;
    private List<String> invitedUserEmails;
    private String wordPackageName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getInvitedUserEmails() {
        return invitedUserEmails;
    }

    public void setInvitedUserEmails(List<String> invitedUserEmails) {
        this.invitedUserEmails = invitedUserEmails;
    }

    public String getWordPackageName() {
        return wordPackageName;
    }

    public void setWordPackageName(String wordPackageName) {
        this.wordPackageName = wordPackageName;
    }
}
