package com.example.springdemo.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@Slf4j
@Service
public class PdfService {
    @SneakyThrows
    public Resource getPdf(String url, String lang) {
        String filePath = "invitation.html";
//        var x = ResourceUtils.getFile("classpath:html/en/manager/invitation.html");
        ByteArrayOutputStream byteArrayOutputStream = createPDF(filePath, url, lang);
        try (OutputStream outputStream = new FileOutputStream("invitation.pdf")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
        return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    }

    private final String INFO_REGEX = "%%%Info%%%";
    private final String NAME_REGEX = "%%%Name%%%";
    private final String URL_REGEX = "%%%URL%%%";

    @SneakyThrows
    public ByteArrayOutputStream createPDF(String filePath, String url, String lang) {
        ClassLoader classLoader = getClass().getClassLoader();
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource(filePath);
        String html = Files.readString(resource.getFile().toPath());
        html = html.replace(URL_REGEX, url);
        ByteArrayOutputStream renderedPdfBytes = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(html, "/");
        builder.toStream(renderedPdfBytes);
        builder.run();
        return renderedPdfBytes;
    }
}