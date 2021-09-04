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
    public String uploadByModelAttribute(@ModelAttribute("request") UploadRequest request) throws Exception {

        log.info("name : {}", request.getName());
        log.info("age : {}", request.getAge());
        log.info("files : {}", request.getFiles());

        for (MultipartFile file : request.getFiles()) {
            String originalFilename = file.getOriginalFilename();
            File dest = new File("C:\\Users\\user\\Desktop\\" + request.getName() + originalFilename);
            file.transferTo(dest);
        }

        return "success upload model";
    }

    @PostMapping("/upload/request-part")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadByRequestPart(@RequestPart("files") List<MultipartFile> files,
                                      @RequestPart("name") String name) throws Exception {

        log.info("name : {}", name);
        log.info("files : {}", files);

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            File dest = new File("C:\\Users\\user\\Desktop\\" + originalFilename);
            file.transferTo(dest);
        }

        return "success upload request-part";
    }

    @PostMapping("/form")
    public String handleFormUpload(UploadRequest form) {

        log.info("name : {}", form.getName());
        log.info("age : {}", form.getAge());
        log.info("files : {}", form.getFiles());

        return "Ok";
    }

}
