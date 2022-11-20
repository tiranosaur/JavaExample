package com.example.springdemo.controller;

import com.example.springdemo.service.PdfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PdfController {
    @Autowired
    private PdfService pdfService;

    @GetMapping(value = "", produces = {"application/pdf"})
    public ResponseEntity<Resource> index() {
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=save_as_file.pdf")
                .body(pdfService.getPdf("https://stackoverflow.com/questions/63529631/creating-file-with-pdfbox-and-downloading-it-solved", "en"));
    }
}