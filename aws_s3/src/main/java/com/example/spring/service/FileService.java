package com.example.spring.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class FileService {
    @Value("${s3.bucket}")
    private String s3Bucket;

    @Autowired
    private AmazonS3 s3;

    @PostConstruct
    public void init() {
        this.createBucketIfNotExists(s3Bucket);
    }

    public void upload(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            s3.putObject(s3Bucket, file.getOriginalFilename(), is, objectMetadata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputStream download(String fileName) {
        ObjectMetadata metadata = s3.getObjectMetadata(s3Bucket, fileName);
        S3Object object = s3.getObject(s3Bucket, fileName);
        return object.getObjectContent();
    }

    private void createBucketIfNotExists(String bucketName) {
        List<Bucket> bucketList = s3.listBuckets();
        if (bucketList.isEmpty()) {
            s3.createBucket(bucketName);
        }
    }

    private void deleteBucket(String bucketName) {
        s3.deleteBucket(bucketName);
    }
}
