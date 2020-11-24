package com.vogame.dto.user.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GetUserByIdResponse extends AbstractVogameResponse<UserDTO> {

    public GetUserByIdResponse() {
    }

    @Builder
    public GetUserByIdResponse(UserDTO payload, Error error) {
        super(payload, error);
    }
}
