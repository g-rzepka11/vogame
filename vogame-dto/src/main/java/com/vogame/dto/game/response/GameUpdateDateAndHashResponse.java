package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class GameUpdateDateAndHashResponse extends AbstractVogameResponse<GameDTO> {

    public GameUpdateDateAndHashResponse() {
    }

    @Builder
    public GameUpdateDateAndHashResponse(GameDTO payload, Error error) {
        super(payload, error);
    }
}
