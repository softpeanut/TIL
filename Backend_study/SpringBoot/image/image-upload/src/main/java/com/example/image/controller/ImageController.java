package com.example.image.controller;

import com.example.image.payload.JsonRequest;
import com.example.image.payload.UploadRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

    // 다중 파일과 json으로 이루어진 객체 보내기
    @PostMapping("/upload/model")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadByModelAttribute(@ModelAttribute UploadRequest request) throws Exception {

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

    // 다중파일과 json 한 번에 보내기
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

    // json과 파일 한 번에 보내기
    @PostMapping(path = "/form", consumes = {"multipart/form-data"})
    public String handleFormUpload(@RequestPart(required = false) JsonRequest form,
                                   @RequestPart(required = true) MultipartFile file) throws IOException {

        log.info("name : {}", form.getName());
        log.info("age : {}", form.getAge());
        log.info("file : {}", file.getOriginalFilename());

        return "success upload form";
    }

}
