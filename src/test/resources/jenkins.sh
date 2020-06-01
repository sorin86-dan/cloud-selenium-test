#!/bin/bash

chmod 400 awsKey
ssh -o StrictHostKeyChecking=no -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo yum update -y
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo yum install docker -y
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo service docker start
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo usermod -a -G docker ec2-user
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} sudo chmod +x /usr/local/bin/docker-compose
scp -i awsKey src/test/resources/Dockerfile ec2-user@${PUT_HERE_IP_ADDRESS}:/home/ec2-user/
scp -i awsKey src/test/resources/docker-compose.yml ec2-user@${PUT_HERE_IP_ADDRESS}:/home/ec2-user/
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} docker-compose up -d
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} docker build -t clone-image .
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} docker run -d --net ec2-user_grid --name automated-code -it clone-image
ssh -i awsKey ec2-user@${PUT_HERE_IP_ADDRESS} docker exec -w /docker-selenium-test/ automated-code mvn clean test