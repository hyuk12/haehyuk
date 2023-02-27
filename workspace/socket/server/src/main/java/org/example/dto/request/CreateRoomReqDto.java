package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateRoomReqDto {
    private String roomName;
    private String kingName;
}
