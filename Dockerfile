FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/ntlg_hw_spring-boot_REST-0.0.1-SNAPSHOT.jar ntlg_hw_dockerTest.jar

CMD ["java", "-jar", "ntlg_hw_dockerTest.jar"]