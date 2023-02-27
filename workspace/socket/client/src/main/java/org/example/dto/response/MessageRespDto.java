package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageRespDto {

	private String message;
	private String toUser;
}
