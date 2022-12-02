package com.example.boardproject.dto;

import com.example.boardproject.domain.UploadFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDTO {
    private String pName;
    private List<MultipartFile> pImageFiles;

}
