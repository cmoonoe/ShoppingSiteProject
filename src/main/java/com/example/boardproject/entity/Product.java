package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    @Column(length = 10)
    private String pName;

    @Column(length = 254)
    private String pImage;

}
