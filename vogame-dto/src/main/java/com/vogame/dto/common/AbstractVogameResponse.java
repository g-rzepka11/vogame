package com.vogame.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class AbstractVogameResponse<T> {
    private T payload;
    private Error error;

    public AbstractVogameResponse() {
    }

    @Builder(builderMethodName = "AbstractVogameResponseBuilder")
    public AbstractVogameResponse(T payload, Error error) {
        this.payload = payload;
        this.error = error;
    }

    @Getter
    @AllArgsConstructor
    public enum Error {
        OTHER_EXCEPTION(1, "Other exception"),
        LEARN_USER_NOT_EXISTS(2, "Learn user not exists");

        private Integer errorCode;
        private String errorDesc;
    }
}
