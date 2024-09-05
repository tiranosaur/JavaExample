#!/bin/bash

# Wait for Graylog to start
until curl -s http://localhost:9000/api/system/inputs | grep -q "inputs"; do
  echo "Waiting for Graylog to be ready..."
  sleep 5
done

# Admin credentials
GRAYLOG_API="http://graylog_demo_graylog:9000/api"
GRAYLOG_USER="admin"
GRAYLOG_PASSWORD="admin" # Используется хэш пароля из файла Docker Compose

# Create GELF UDP input
curl -u $GRAYLOG_USER:$GRAYLOG_PASSWORD -X POST "${GRAYLOG_API}/system/inputs" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "GELF UDP",
    "type": "org.graylog2.inputs.gelf.udp.GELFUDPInput",
    "configuration": {
      "bind_address": "0.0.0.0",
      "port": 12201,
      "recv_buffer_size": 1048576,
      "decompress_size_limit": 8388608,
      "override_source": null
    },
    "global": true,
    "node": null
  }'
