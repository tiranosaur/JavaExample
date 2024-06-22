<%@ page import="static org.example.demojsp.Constants.*" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><%= request.getAttribute("title") %>
    </title>
</head>
<body>
<header>
    <% if (request.getAttribute(LAYOUT_HEADER) != null && !"".equals(request.getAttribute(LAYOUT_HEADER))) { %>
    <jsp:include page='${requestScope.HeaderContentJSP}'/>
    <% } %>
</header>

<main>
    <% if (request.getAttribute("MainContentJSP") != null && !"".equals(request.getAttribute("MainContentJSP"))) { %>
    <jsp:include page='${requestScope.MainContentJSP}'/>
    <% } %>
</main>

<footer>
    <% if (request.getAttribute(LAYOUT_FOOTER) != null && !"".equals(request.getAttribute(LAYOUT_FOOTER))) { %>
    <jsp:include page="${requestScope.FooterContentJSP}"/>
    <% } %>
</footer>
</body>
</html>