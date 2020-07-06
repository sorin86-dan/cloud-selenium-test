FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
     apt-get install -y awscli

RUN curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" && \
    unzip awscliv2.zip && \
    ./aws/install

USER jenkins