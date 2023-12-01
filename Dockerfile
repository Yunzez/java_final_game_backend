# 使用官方的Java运行环境作为基础镜像
FROM openjdk:17-jdk-alpine

# 添加一个卷，用于临时文件存储，这样可以提高应用的运行性能
VOLUME /tmp

# 将你的jar文件添加到镜像中
ADD final_backend/target/final_backend-0.0.1-SNAPSHOT.jar final_backend.jar

# 声明应用打算使用的8080端口
EXPOSE 8080

# 运行你的jar文件
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/final_backend.jar"]