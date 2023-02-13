package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class JoinRespDto {
    private String welcomeMessage;
    private List<String> connectedUsers;
}
