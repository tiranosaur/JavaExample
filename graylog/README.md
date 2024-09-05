# http://localhost:9000/

# admin

# admin

1. запускаем грейлог из [docker-compose.yml](graylog%2Fdocker-compose.yml)
2. получаем ip

```text
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' graylog_demo_graylog
```

3. вставляем ip
4. настраиваем локальный inputs
5. радуемся