package com.example.boardproject.entity;

import com.example.boardproject.domain.UploadFile;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "productFiles",
            joinColumns = @JoinColumn(name = "iId", referencedColumnName = "pId"))
    private List<UploadFile> pImageFiles;

    public Product(String pName, List<UploadFile> pImageFiles) {
        this.pName = pName;
        this.pImageFiles = pImageFiles;
    }
}