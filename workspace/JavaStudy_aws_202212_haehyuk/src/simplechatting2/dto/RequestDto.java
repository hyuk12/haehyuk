package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestDto {
    private String resource;
    private String body;
}
