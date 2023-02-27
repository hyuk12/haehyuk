package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExitReqDto {
	private String nickname;
	private String roomName;
}
