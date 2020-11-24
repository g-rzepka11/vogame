package com.vogame.dto.word.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.word.WordPackageDataDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GetWordPackagesResponse extends AbstractVogameResponse<List<WordPackageDataDTO>> {

    public GetWordPackagesResponse() {
    }

    @Builder
    public GetWordPackagesResponse(List<WordPackageDataDTO> payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
