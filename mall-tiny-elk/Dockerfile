# docker build --platform=linux/amd64 -t arronyr/zxdd-admin:latest .

# 使用具有 Maven 和 JDK 8 的基础镜像
FROM maven:3.6.3-jdk-8 as builder

# 设置工作目录
WORKDIR /app

# 复制本地代码到容器中
COPY . /app

# 使用 Maven 构建应用
RUN mvn clean package -DskipTests

# 使用 JDK 8 的轻量级基础镜像
FROM openjdk:8-slim

RUN apt-get update
RUN apt-get install -y fontconfig libfreetype6 iproute2 procps

# 从构建阶段复制构建好的 JAR 文件
COPY --from=builder /app/target/*.jar /app/app.jar

ENV TZ 'Asia/Shanghai'

# 设置环境变量，以便可以在运行时调整参数
ENV JAVA_OPTS=""

ENV SP_OPTS="-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -Dserver.port=${PORT} -Dfile.encoding=utf-8"

# 运行 Java 应用
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/app.jar ${SP_OPTS}"]

