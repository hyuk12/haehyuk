package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto<T> {
    private String resource;
    private T body;
}
