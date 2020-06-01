FROM openjdk:8
MAINTAINER Sorin Dan (dansorin2006@gmail.com)

USER root

#=============================================================
# Install Git
#=============================================================
RUN apt-get update && \
     apt-get install git -y

#=============================================================
# Install Maven
#=============================================================
RUN apt-get update && \
     apt-get install maven -y

#=============================================================
# Clone code
#=============================================================
RUN git clone https://github.com/sorin86-dan/cloud-selenium-test.git

#=============================================================
# Build code
#=============================================================
RUN cd docker-selenium-test && \
    mvn clean install -DskipTests