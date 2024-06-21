<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.get("title")}</title>
</head>
<body>
<div style="border: 1px solid black">
    <% for (String filename : (List<String>) request.getAttribute("fileList")) { %>
    <div>
        <%= filename %>
    </div>
    <% } %>
</div>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Send</button>
</form>

</body>
</html>
