package com.example.image.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Getter
@AllArgsConstructor
public class UploadRequest {
    private String name;
    private int age;

    private List<MultipartFile> files;
}
