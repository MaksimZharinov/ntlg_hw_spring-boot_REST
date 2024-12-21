FROM alpine:latest

RUN apt-get update && apt-get install -y openjdk-23-jre-headless

ENV JAVA_HOME /usr/lib/jvm/java-23-openjdk
ENV PATH "$JAVA_HOME/bin:$PATH"

EXPOSE 8080

ADD target/ntlg_hw_spring-boot_REST-0.0.1-SNAPSHOT.jar ntlg_hw_dockerTest.jar

CMD ["java", "-jar", "ntlg_hw_dockerTest.jar"]