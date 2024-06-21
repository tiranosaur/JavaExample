package org.example.demojsp.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {
    private static final Logger log = LogManager.getLogger();

    private FileUtil() {
    }

    public static List<String> getFileList(String path) {
        List<String> fileList = new ArrayList<>();

        try (Stream<Path> pathSet = Files.list(Paths.get(path))) {
            pathSet.forEach(x -> fileList.add(x.getFileName().toString()));
        } catch (Exception ex) {
            log.error("Error while getting files", ex);
        }
        return fileList;
    }
}
