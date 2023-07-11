FROM ubuntu19-jdk

MAINTAINER username "username@gmail.com"

ENV hey=dockerversion

WORKDIR /usr/local/bin

ADD target/ProjectManagement-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "ProjectManagement-0.0.1-SNAPSHOT.jar"]