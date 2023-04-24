package com.study.board.controller.dto;

import com.study.board.entity.Post;
import lombok.*;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReqDto {
    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .createdDate(new Date())
                .modifiedDate(new Date())
                .build();
    }
}
