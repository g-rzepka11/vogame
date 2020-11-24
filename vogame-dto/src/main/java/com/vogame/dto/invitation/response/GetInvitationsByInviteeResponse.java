package com.vogame.dto.invitation.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.invitation.InvitationDTO;
import lombok.Builder;

import java.util.List;

public class GetInvitationsByInviteeResponse extends AbstractVogameResponse<List<InvitationDTO>> {

    public GetInvitationsByInviteeResponse() {
    }

    @Builder
    public GetInvitationsByInviteeResponse(List<InvitationDTO> payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
