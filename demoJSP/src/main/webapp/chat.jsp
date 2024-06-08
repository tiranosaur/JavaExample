<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat Room</title>
    <script type="text/javascript">
        var ws;

        function connect() {
            var log = document.getElementById("log");
            ws = new WebSocket("ws://" + window.location.host + "<%= request.getContextPath() %>/chat");
            ws.onmessage = function (event) {
                log.innerHTML += event.data + "<br>";
            };
        }

        function sendMessage() {
            var log = document.getElementById("log");
            var input = document.getElementById("message");

            ws.send(input.value);
            log.innerHTML += '<p style="color: darkred; margin: 0">' + input.value + '</p>';
            input.value = '';
        }

        window.onload = connect;
    </script>
</head>
<body>
<h1>Chat Room</h1>
<div id="log" style="border: 1px solid black; height: 300px; overflow-y: scroll;"></div>
<input type="text" id="message" onkeypress="if(event.keyCode==13) sendMessage();"/>
<button onclick="sendMessage()">Send</button>
</body>
</html>
