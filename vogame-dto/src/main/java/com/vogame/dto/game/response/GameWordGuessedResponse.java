package com.vogame.dto.game.response;

import com.vogame.dto.game.GameDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class GameWordGuessedResponse extends AbstractVogameResponse<GameDTO> {

    public GameWordGuessedResponse() {
    }

    @Builder
    public GameWordGuessedResponse(GameDTO payload, Error error) {
        super(payload, error);
    }
}
