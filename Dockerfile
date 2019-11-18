#
FROM frolvlad/alpine-java:jdk8-slim
#
VOLUME /tmp
#
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
#
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#
EXPOSE 7090
