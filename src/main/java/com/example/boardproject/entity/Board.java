package com.example.boardproject.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private int bId;

    @Column(length = 30, nullable = false)
    private String bTitle;

    @Column(length = 20, nullable = false)
    private String bWriter;

    @Column(length = 100, nullable = false)
    private String bContent;

    @CreationTimestamp
    private Timestamp bDate;

    @Column
    private String bImage;

    @Column(length = 20, nullable = false)
    private String bPw;
}
