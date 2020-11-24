package com.vogame.config;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.exception.LearnUserNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = LearnUserNotExistsException.class)
    public ResponseEntity<AbstractVogameResponse> learnUserNotExistsException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(AbstractVogameResponse.AbstractVogameResponseBuilder()
                        .error(AbstractVogameResponse.Error.LEARN_USER_NOT_EXISTS)
                        .build());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<AbstractVogameResponse> exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(AbstractVogameResponse.AbstractVogameResponseBuilder()
                        .error(AbstractVogameResponse.Error.OTHER_EXCEPTION)
                        .build());
    }

}
