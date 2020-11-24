package com.vogame.dto.invitation.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.invitation.InvitationDTO;
import lombok.Builder;

import java.util.List;

public class GetInvitationsByGameIdResponse extends AbstractVogameResponse<List<InvitationDTO>> {

    public GetInvitationsByGameIdResponse() {
    }

    @Builder
    public GetInvitationsByGameIdResponse(List<InvitationDTO> payload, Error error) {
        super(payload, error);
    }
}
