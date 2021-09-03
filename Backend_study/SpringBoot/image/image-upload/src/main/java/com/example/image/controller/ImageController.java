package com.example.image.controller;

import com.example.image.payload.UploadRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

    @PostMapping("/upload/model")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@ModelAttribute(value = "request") UploadRequest request) throws Exception {

        log.info("name : {}", request.getName());
        log.info("age : {}", request.getAge());
        log.info("files : {}", request.getMultipartFiles());

        for (MultipartFile file : request.getMultipartFiles()) {
            File dest = new File("C:\\Users\\user\\Desktop\\" + request.getName());
            file.transferTo(dest);
        }

        return "success upload model";
    }

}
