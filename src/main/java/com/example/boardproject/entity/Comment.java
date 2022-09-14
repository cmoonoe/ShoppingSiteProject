package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId;

    @Column(length = 100, nullable = false)
    private String cContent;

    @Column(length = 20, nullable = false)
    private String cWriter;

    @Column(nullable = false)
    private LocalDate cDate;

    @Column(length = 20, nullable = false)
    private String cPw;

    @ManyToOne
    @JoinColumn(name = "bId")
    private Board board;
}
