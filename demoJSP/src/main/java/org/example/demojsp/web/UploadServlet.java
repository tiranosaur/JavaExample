package org.example.demojsp.web;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.demojsp.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.example.demojsp.Constants.*;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger();
    private static String uploadPath;
    private static final String UPLOAD_PAGE_PATH = "/file/upload.jsp";

    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet");
        request.setAttribute("title", "Upload Page");
        request.setAttribute("fileList", FileUtil.getFileList(uploadPath));
        getServletContext().getRequestDispatcher(UPLOAD_PAGE_PATH).forward(request, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
                        }
                    }
                }
            } catch (Exception ex) {
                log.error("Error while uploading file", ex);
                throw new ServletException(ex);
            }

            request.setAttribute("fileList", FileUtil.getFileList(uploadPath));
            getServletContext().getRequestDispatcher(UPLOAD_PAGE_PATH).forward(request, response);
        }
    }
}