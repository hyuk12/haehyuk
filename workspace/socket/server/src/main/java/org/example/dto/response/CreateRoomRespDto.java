package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateRoomRespDto {
    private String roomName;
    private String kingName;
}
