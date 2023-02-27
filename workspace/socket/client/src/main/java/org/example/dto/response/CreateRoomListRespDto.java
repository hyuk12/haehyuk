package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CreateRoomListRespDto {
    private List<String> roomNameList;
}
