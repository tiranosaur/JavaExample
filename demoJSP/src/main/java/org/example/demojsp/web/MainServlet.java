package org.example.demojsp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.demojsp.Constants.LAYOUT_MAIN;
import static org.example.demojsp.Constants.LAYOUT_PATH;

@WebServlet(name = "main", value = "/")
public class MainServlet extends HttpServlet {
    private static final String TITLE = "Main Page";
    private static final String PATH = "/main";
    private static final String INDEX = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", TITLE);
        req.setAttribute(LAYOUT_MAIN, PATH + INDEX);
        getServletContext().getRequestDispatcher(LAYOUT_PATH).forward(req, resp);
    }
}
