package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;

    @Column(length = 20, unique = true, nullable = false)
    private String loginId;

    @Column(length = 20, nullable = false)
    private String password;

    public Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
