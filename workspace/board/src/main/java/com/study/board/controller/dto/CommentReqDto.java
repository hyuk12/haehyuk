package com.study.board.controller.dto;

import com.study.board.entity.Comment;
import com.study.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CommentReqDto {
    private Long postId;
    private Long parentId;
    private String content;

    public Comment toEntity(Post post, Comment parentComment) {
        return Comment.builder()
                .content(content)
                .post(post)
                .parentComment(parentComment)
                .build();
    }

}
