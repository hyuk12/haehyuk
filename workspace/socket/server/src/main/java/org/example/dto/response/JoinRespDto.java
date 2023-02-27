package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import org.example.entity.Room;

@AllArgsConstructor
@Getter
public class JoinRespDto {
    private String nickname;
}
