package com.vogame.dto.invitation.response;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.invitation.InvitationDTO;
import lombok.Builder;

import java.util.List;

public class GetInvitationsByHostUserIdResponse extends AbstractVogameResponse<List<InvitationDTO>> {

    public GetInvitationsByHostUserIdResponse() {
    }

    @Builder
    public GetInvitationsByHostUserIdResponse(List<InvitationDTO> payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
