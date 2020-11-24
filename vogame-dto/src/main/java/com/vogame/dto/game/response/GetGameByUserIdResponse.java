package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

import java.util.List;

public class GetGameByUserIdResponse extends AbstractVogameResponse<List<GameDTO>> {

    public GetGameByUserIdResponse() {
    }

    @Builder
    public GetGameByUserIdResponse(List<GameDTO> payload, Error error) {
        super(payload, error);
    }
}
