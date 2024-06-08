<%

%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${title}</title>
</head>
<body>
<div>
    <form action="user?action=create" method="post">
        <input type="hidden" id="id" name="id" value="${user.getId()}">
        <p><input type="text" id="name" name="name" placeholder="name" value="${user.getName()}"></p>
        <p><input type="text" id="email" name="email" placeholder="email" value="${user.getEmail()}"></p>
        <p><input type="text" id="country" name="country" placeholder="country" value="${user.getCountry()}"></p>
        <p>
            <button type="submit">Save</button>
        </p>
    </form>
</div>
</body>
</html>