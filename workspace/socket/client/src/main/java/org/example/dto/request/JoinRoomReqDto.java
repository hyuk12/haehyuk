package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JoinRoomReqDto {

    private String roomName;
    private String joinName;

}
