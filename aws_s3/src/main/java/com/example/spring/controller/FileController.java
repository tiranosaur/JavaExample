package com.example.spring.controller;

import com.example.spring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;


    @GetMapping
    public String uploadFile() throws IOException {
        fileService.upload(null);
        return "File uploaded successfully.";
    }

    @PostMapping
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.upload(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
        InputStream inputStream = fileService.download(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(inputStream);
    }
}
