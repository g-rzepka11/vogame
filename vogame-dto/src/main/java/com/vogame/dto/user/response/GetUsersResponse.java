package com.vogame.dto.user.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.learn.LearnConfigDTO;
import com.vogame.dto.user.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GetUsersResponse extends AbstractVogameResponse<List<UserDTO>> {

    public GetUsersResponse() {
    }

    @Builder
    public GetUsersResponse(List<UserDTO> payload, Error error) {
        super(payload, error);
    }
}
