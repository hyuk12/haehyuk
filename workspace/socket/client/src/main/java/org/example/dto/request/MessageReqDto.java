package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageReqDto {

    private String message;
    private String toUser;
}
