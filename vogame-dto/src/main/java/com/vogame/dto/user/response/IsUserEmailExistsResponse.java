package com.vogame.dto.user.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

@Data
public class IsUserEmailExistsResponse extends AbstractVogameResponse<Boolean> {

    public IsUserEmailExistsResponse() {
    }

    @Builder
    public IsUserEmailExistsResponse(Boolean payload, Error error) {
        super(payload, error);
    }
}
