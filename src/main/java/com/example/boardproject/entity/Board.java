package com.example.boardproject.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(value = {AuditingEntityListener.class})
public class Board {

    @Id
    @Column(name="bId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bId;

    @Column(length = 30, name="bTitle",nullable = false)
    private String bTitle;

    @Column(length = 20, name="bWriter",nullable = false)
    private String bWriter;

    @Column(name="bDate", nullable = false,updatable = false)
    @CreatedDate
    private LocalDateTime bDate;

    @Column(length = 100, name="bContent")
    private String bContent;

    @Column(name="bImage")
    private String bImage;

    @Column(length = 20,name="bPw", nullable = false)
    private String bPw;

    @ManyToOne
    @JoinColumn(name = "pId")
    private Product pId;

}
