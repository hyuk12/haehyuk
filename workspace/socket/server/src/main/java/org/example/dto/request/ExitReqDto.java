package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExitReqDto {
	private String nickname;
	private String roomName;
}
