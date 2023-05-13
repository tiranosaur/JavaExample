FROM openjdk:17

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование JAR-файла с сервером в контейнер
COPY target/spring-0.0.1-SNAPSHOT.jar app.jar

# Определение переменной среды для Java
ENV JAVA_OPTS=""

# Определение порта, который будет прослушиваться сервером
EXPOSE 8080

# Запуск сервера при старте контейнера
ENTRYPOINT ["java", "-jar", "app.jar"]
