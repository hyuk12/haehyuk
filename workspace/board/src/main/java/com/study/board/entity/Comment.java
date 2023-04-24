package com.study.board.entity;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment_tb")
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

    // ManyToOne 관계에서는 mappedBy를 사용하지 않는다.
    // mappedBy는 OneToMany 관계에서만 사용한다.
    // mappedBy는 연관관계의 주인이 아니다. (FK가 아니다.)
    // mappedBy는 연관관계의 주인이 아니기 때문에 insert, update, delete를 수행하지 않는다.
    // mappedBy는 단지 조회만 가능하다.
    // mappedBy는 연관관계의 주인이 아니기 때문에 mappedBy를 사용하는 엔티티를 영속화할 때 연관관계의 주인 엔티티를 함께 영속화해야 한다.
    // ManyToOne 으로 자기 자신을 참조하여 대댓글 구현하기

    // 대댓글을 구현하기 위해서는 자기 자신을 참조하는 ManyToOne 관계를 만들어야 한다.
    @ManyToOne(targetEntity = Comment.class)
    private Comment parentComment;

    // 대댓글을 구현하기 위해서는 자기 자신을 참조하는 OneToMany 관계를 만들어야 한다.
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> childComments = new ArrayList<>();
}
