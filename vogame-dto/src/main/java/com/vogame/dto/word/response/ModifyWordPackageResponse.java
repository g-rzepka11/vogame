package com.vogame.dto.word.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.word.WordPackageDTO;
import lombok.Builder;
import lombok.Data;

@Data
public class ModifyWordPackageResponse extends AbstractVogameResponse<WordPackageDTO> {

    public ModifyWordPackageResponse() {
    }

    @Builder
    public ModifyWordPackageResponse(WordPackageDTO payload, Error error) {
        super(payload, error);
    }
}
