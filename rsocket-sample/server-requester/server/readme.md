<h1 style="color: red">you can use test.http for testing</h1>
<h3>brew install yschimke/tap/rsocket-cli</h3>
<ul style="font-size: 16px">
    <li><b>ping</b> - <dfn>rsocket-cli --request --debug tcp://localhost:7000 --route=ping</dfn></li>
    <li><b>connect</b> - <dfn>rsocket-cli --metadataPush --debug tcp://localhost:7000 --route=connect --dataFormat=application/json --metadataFormat=application/json  -m '{"user" : "value"}' </dfn></li>
    
</ul>