package com.vogame.dto.word;

import java.util.Date;

public class WordPackageDataDTO {
    private Long id;
    private String wordPackageName;
    private Boolean isPrivate;
    private Long userId;
    private Date createdAt;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWordPackageName() {
        return wordPackageName;
    }

    public void setWordPackageName(String wordPackageName) {
        this.wordPackageName = wordPackageName;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
