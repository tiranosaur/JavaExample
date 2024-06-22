<%@ taglib prefix="ex" uri="/WEB-INF/tld/custom.tld" %>
<div>
    <p><a href="hello-servlet">Hello Servlet</a></p>
    <p><a href="user">User Servlet</a></p>
    <p><a href="upload">Upload File</a></p>
    <p><a href="chat/index.jsp">Enter Chat</a></p>
</div>
<h4>Random number(custom tag) <ex:MyTag/></h4>
<h4>Random number <ex:MyTag message="(custom tag with param)" max="1000"/></h4>