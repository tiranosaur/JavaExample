<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%
    List<String> list = Arrays.asList("aaa", "bbb", "cccO;");
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World! 111" %>
</h1>
<div style="background: red">
    <c:out value="slkdfjlskdjf"/>
    <c:forEach var="xxx" items="list">
        <c:out value="${xxx}"/>
    </c:forEach>
</div>
<br/>
<p><a href="hello-servlet">Hello Servlet</a></p>
<p><a href="user">User Servlet</a></p>
</body>
</html>