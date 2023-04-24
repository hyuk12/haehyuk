package com.study.board.service;

import com.study.board.controller.dto.CommentReqDto;
import com.study.board.controller.dto.PostReqDto;
import com.study.board.entity.Comment;
import com.study.board.entity.Post;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public void createBoard(PostReqDto postReqDto){
        boardRepository.save(postReqDto.toEntity());
    }

    public void createComment(CommentReqDto commentReqDto){
        Post postById = boardRepository.findPostById(commentReqDto.getPostId());
        if(postById == null){
            throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다.");
        }

        Comment parentComment = null;
        if (commentReqDto.getParentId() != null) {
            parentComment = commentRepository.findById(commentReqDto.getParentId()).orElseThrow(
                    () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
            );
        }

        Comment entity = commentReqDto.toEntity(postById, parentComment);
        postById.getComments().add(entity);
        commentRepository.save(entity);
    }
}
