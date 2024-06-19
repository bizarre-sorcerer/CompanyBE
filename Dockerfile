# Используем официальный образ OpenJDK 17 для Alpine Linux
FROM openjdk:17-jdk-alpine

# Аргумент сборки для указания пути к JAR файлу
ARG JAR_FILE=target/*.jar

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл из среды сборки в контейнер
COPY ${JAR_FILE} app.jar

# Команда для запуска приложения при старте контейнера
ENTRYPOINT ["java", "-jar", "app.фjar"]