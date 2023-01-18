FROM openjdk:9

COPY target/BootMVCProj22-CurdOperationUsingThymeleaf.jar  /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "BootMVCProj22-CurdOperationUsingThymeleaf.jar"]