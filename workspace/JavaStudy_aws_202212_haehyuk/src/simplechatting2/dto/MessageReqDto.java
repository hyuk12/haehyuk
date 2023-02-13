package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageReqDto {
    private String toUser;
    private String fromUser;
    private String messageValue;
}
