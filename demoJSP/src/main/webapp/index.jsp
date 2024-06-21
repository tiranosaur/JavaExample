<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ex" uri="/WEB-INF/tld/custom.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Main Page" %>
</h1>
<div>
    <p><a href="hello-servlet">Hello Servlet</a></p>
    <p><a href="user">User Servlet</a></p>
    <p><a href="upload">Upload File</a></p>
    <p><a href="chat.jsp">Enter Chat</a></p>
</div>
<h4>Random number(custom tag) <ex:MyTag/></h4>
<h4>Random number <ex:MyTag message="(custom tag with param)" max="1000"/></h4>
</body>
</html>