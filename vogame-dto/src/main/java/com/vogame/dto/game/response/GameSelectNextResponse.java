package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class GameSelectNextResponse extends AbstractVogameResponse<GameDTO> {

    public GameSelectNextResponse() {
    }

    @Builder
    public GameSelectNextResponse(GameDTO payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
