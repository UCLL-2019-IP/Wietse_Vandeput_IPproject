FROM debian
RUN apt update
RUN apt -y upgrade
RUN apt -y install default-jdk
ADD umami.jar /
ADD src /src
CMD ["java", "-jar", "umami.jar"]
