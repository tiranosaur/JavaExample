<h3>brew install yschimke/tap/rsocket-cli</h3>
<ul style="font-size: 16px">
    <li><b>test</b> - <dfn>rsocket-cli --request --debug ws://localhost:8081/rsocket --route=test</dfn></li>
    <li><b>test-string</b> - <dfn>rsocket-cli --request --debug ws://localhost:8081/rsocket --route=test-string -i "ping"</dfn></li>
    <li><b>hello</b> - <dfn>rsocket-cli --request --debug ws://localhost:8081/rsocket --route=hello --dataFormat="application/json" -i "{\"message\": \"hello\"}"</dfn></li>
    <li><b>greet.{name}</b> - <dfn>rsocket-cli --request --debug ws://localhost:8081/rsocket --route=greet.tiranosaur --dataFormat="application/json" -i "{\"message\": \"hello\"}"</dfn></li>
    <li><b>greet-stream</b> - <dfn>rsocket-cli --stream --debug ws://localhost:8081/rsocket --route=greet-stream --dataFormat="application/json" -i "{\"message\": \"hello\"}"</dfn></li>
    <li><b>greet-channel</b> - <dfn>rsocket-cli --channel --debug ws://localhost:8081/rsocket --route=greet-channel --dataFormat="application/json" -i "{\"message\": \"hello\"}"</dfn></li>
    <li><b>numbers-stream</b> - <dfn>rsocket-cli --stream --debug ws://localhost:8081/rsocket --route=numbers-stream</dfn></li>
</ul>

