<%@ page import="org.example.demojst.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px 10px;
        }
    </style>
    <title>${title}</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th>country</th>
            <th>action</th>
        </tr>
        <% for (User user : (List<User>) request.getAttribute("userList")) { %>
        <tr>
            <td>
                <%= user.getId() %>
            </td>
            <td>
                <%= user.getName() %>
            </td>
            <td>
                <%= user.getEmail() %>
            </td>
            <td>
                <%= user.getCountry() %>
            </td>
            <td>
                <button onclick="window.location='user?action=edit&id=<%=user.getId()%>'">EDIT</button>
                <button onclick="window.location='user?action=delete&id=<%=user.getId()%>'">DELETE</button>
            </td>
        </tr>
        <% } %>
    </table>
</div>
<div>
    <button onclick="window.location='user?action=create'">CREATE</button>
</div>
</body>
</html>
