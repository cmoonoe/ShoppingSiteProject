package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bId;

    @Column(length = 30, nullable = false)
    private String bTitle;

    @Column(length = 20, nullable = false)
    private String bWriter;

    @Column(length = 100, nullable = false)
    private String bContent;

    @Column
    private LocalDateTime bDate;

    @Column
    private String bImage;

    @Column(length = 20, nullable = false)
    private String bPw;
}
