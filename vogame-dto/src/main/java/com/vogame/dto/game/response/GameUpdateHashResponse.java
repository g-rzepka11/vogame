package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class GameUpdateHashResponse extends AbstractVogameResponse<GameDTO> {

    public GameUpdateHashResponse() {
    }

    @Builder
    public GameUpdateHashResponse(GameDTO payload, Error error) {
        super(payload, error);
    }
}
