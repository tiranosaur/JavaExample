package org.example.demojsp.web;

import org.example.demojsp.dao.UserDAO;
import org.example.demojsp.model.User;
import org.example.demojsp.util.TypeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "user-servlet", value = "/user")
public class UserServlet extends HelloServlet {
    private static final String PATH = "/user";
    private static final String FORM_PATH_JSP = "/user/form.jsp";
    private static final String LIST_PATH_JSP = "/user/list.jsp";
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        try {
            switch (action) {
                case "create":
                    request.setAttribute("title", "Create User");
                    showForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                case "edit":
                    request.setAttribute("title", "Edit User");
                    editUser(request, response);
                default:
                    listUser(request, response);
                    break;
            }
        } catch (Exception e) {
            response.setStatus(404);
        }
    }


    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(FORM_PATH_JSP).forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setAttribute("title", "User List");
        List<User> userList = userDAO.selectAllUsers();
        request.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher(LIST_PATH_JSP).forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher(FORM_PATH_JSP).forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect(getServletContext().getContextPath() + PATH);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "create":
                request.setAttribute("title", "Created User");
                createUser(request, response);
                break;
            default:
                throw new RuntimeException("invalid action");
        }

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer id = TypeUtil.parseInteger(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            User user = new User(id, name, email, country);

            if (id != null) {
                userDAO.updateUser(user);
            } else {
                userDAO.insertUser(user);
            }

            response.sendRedirect(getServletContext().getContextPath() + PATH);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
