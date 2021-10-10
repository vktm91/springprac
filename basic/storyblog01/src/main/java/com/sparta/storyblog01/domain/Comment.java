package com.sparta.storyblog01.domain;

import com.sparta.storyblog01.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends TimeStamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column
    private String deletecomment;


//    @ManyToOne
//    @JoinColumn(name = "storyId", nullable = false)
//    private Story id;

    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.deletecomment = requestDto.getDeletecomment();
    }
}
