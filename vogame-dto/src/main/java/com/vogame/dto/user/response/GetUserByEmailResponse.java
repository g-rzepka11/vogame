package com.vogame.dto.user.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

@Data
public class GetUserByEmailResponse extends AbstractVogameResponse<UserDTO> {

    public GetUserByEmailResponse() {
    }

    @Builder
    public GetUserByEmailResponse(UserDTO payload, Error error) {
        super(payload, error);
    }
}
