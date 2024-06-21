package org.example.demojsp.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "helloServlet", value = "/hello-servlet",
        initParams = {
                @WebInitParam(name = "greet", value = "Hello, World!"),
                @WebInitParam(name = "email", value = "contact@example.com")
        }
)
public class HelloServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(HelloServlet.class);
    private String message;

    public void init() {
        System.out.println(getInitParameter("greet"));
        System.out.println(getInitParameter("email"));
        message = "Hello World!";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("==== GOT REQUEST ====");
        super.service(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}