package org.example.demojsp;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Constants {
    private Constants() {
    }

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String UPLOAD_DIRECTORY = "upload";
    public static final String DEFAULT_FILENAME = "default.file";

    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
}
