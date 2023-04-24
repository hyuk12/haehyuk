package com.study.board.controller;

import com.study.board.controller.dto.CommentReqDto;
import com.study.board.controller.dto.PostReqDto;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> createBoard(@RequestBody PostReqDto postReqDto) {
        boardService.createBoard(postReqDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/board/comment")
    public ResponseEntity<?> createComment(@RequestBody CommentReqDto commentReqDto) {
        boardService.createComment(commentReqDto);
        return ResponseEntity.ok().build();
    }
}
