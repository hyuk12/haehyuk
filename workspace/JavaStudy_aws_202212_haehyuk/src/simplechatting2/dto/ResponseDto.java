package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto {
    private String resource;
    private String status;
    private String body;
}
