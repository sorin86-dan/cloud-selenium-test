#!/bin/bash

chmod 400 awsKey
aws configure set aws_access_key_id AKIAYKJFACCLURUGGZFG && \
     aws configure set aws_secret_access_key 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 && \
     aws configure set default.region us-east-1
aws ec2 run-instances --image-id ami-09d95fab7fff3776c \
      --instance-type t2.micro \
      --security-group-ids sg-070f2428 \
      --key-name MyKeyPair
EC2_IP=$(aws ec2 describe-instances | grep PublicIpAddress | awk '{print $2}' | cut -d '"' -f 2)
EC2_ID=$(aws ec2 describe-instances | grep InstanceId | awk '{print $2}' | cut -d '"' -f 2)
ssh -o StrictHostKeyChecking=no -i awsKey ec2-user@$EC2_IP sudo yum update -y
ssh -i awsKey ec2-user@$EC2_IP sudo yum install docker -y
ssh -i awsKey ec2-user@$EC2_IP sudo service docker start
ssh -i awsKey ec2-user@$EC2_IP sudo usermod -a -G docker ec2-user
ssh -i awsKey ec2-user@$EC2_IP sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
ssh -i awsKey ec2-user@$EC2_IP sudo chmod +x /usr/local/bin/docker-compose
scp -i awsKey src/test/resources/Dockerfile ec2-user@${PUT_HERE_IP_ADDRESS}:/home/ec2-user/
scp -i awsKey src/test/resources/docker-compose.yml ec2-user@${PUT_HERE_IP_ADDRESS}:/home/ec2-user/
ssh -i awsKey ec2-user@$EC2_IP docker-compose up -d
ssh -i awsKey ec2-user@$EC2_IP docker build -t clone-image .
ssh -i awsKey ec2-user@$EC2_IP docker run -d --net ec2-user_grid --name automated-code -it clone-image
ssh -i awsKey ec2-user@$EC2_IP docker exec -w /cloud-selenium-test/ automated-code mvn clean test
aws ec2 terminate-instances --instance-ids $EC2_ID
