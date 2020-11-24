package com.vogame.dto.word.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.word.WordPackageDTO;
import lombok.Builder;
import lombok.Data;

@Data
public class GetWordPackageByIdResponse extends AbstractVogameResponse<WordPackageDTO> {

    public GetWordPackageByIdResponse() {
    }

    @Builder
    public GetWordPackageByIdResponse(WordPackageDTO payload, Error error) {
        super(payload, error);
    }
}
