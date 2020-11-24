package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class GetGameByIdResponse extends AbstractVogameResponse<GameDTO> {

    public GetGameByIdResponse() {
    }

    @Builder
    public GetGameByIdResponse(GameDTO payload, Error error) {
        super(payload, error);
    }
}
