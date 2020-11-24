package com.vogame.dto.word.response;

import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class IsWordPackageByNameExistsResponse extends AbstractVogameResponse<Boolean> {

    public IsWordPackageByNameExistsResponse() {
    }

    @Builder
    public IsWordPackageByNameExistsResponse(Boolean payload, Error error) {
        super(payload, error);
    }
}
