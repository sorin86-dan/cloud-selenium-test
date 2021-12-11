# Running tests with Selenium Grid

1. Start Selenium hub and nodes connected to it.
2. Connect test automation code to the ip of the Selenium Hub.
3. Start running the tests.

## Start Selenium Grid made of a hub, a Chrome node and a Firefox node without using json files

In the folder where the file **selenium-server-standalone-3.141.59.jar** is present run the following commands:
```shell script
java -jar selenium-server-standalone-3.141.59.jar -role hub
java -Dwebdriver.chrome.driver=<path-to-chromedriver> -jar selenium-server-standalone-3.141.59.jar -role node
java -Dwebdriver.gecko.driver=<path-to-geckodriver> -jar selenium-server-standalone-3.141.59.jar -role node
```

## Start Selenium Grid made of a hub, a Chrome node and a Firefox node using json files

In the folder where the file **selenium-server-standalone-3.141.59.jar** is present run the following commands:
```shell script
java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig src/test/resources/hubConfig.json
java -Dwebdriver.chrome.driver=<path-to-chromedriver> -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig <path-to-node-chrome-json-config>
java -Dwebdriver.gecko.driver=<path-to-geckodriver> -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig <path-to-node-firefox-json-config>
```

# Running tests in Docker containers

1. Create a Docker network with a Selenium hub, 1 chrome node and 1 firefox node.
2. Start running the tests.

It's just as simply as that!

## Linux (Ubuntu)

### Create Docker network for Selenium tests 
To build the Docker network make sure you have a valid Internet connection and run the commands below:
```shell script
 docker network create --subnet=172.0.0.0/16 grid
 docker run -d -p 4444:4444 --net grid --ip 172.0.0.2 --name selenium-hub selenium/hub:3.141.59-zinc
 
 docker run -d --net grid --ip 172.0.0.3 -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-zinc
 docker run -d --net grid --ip 172.0.0.4 -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-zinc
```

### Check the load on the nodes
You need to open Selenium hub page for this. So open in browser: **http://172.0.0.2:4444/grid/console**

If you want to open the selenium node containers create the grid with the following commands:
```shell script
 docker network create --subnet=172.0.0.0/16 grid
 docker run -d -p 4444:4444 --net grid --ip 172.0.0.2 --name selenium-hub selenium/hub:3.141.59-zinc
 
 docker run -d -P -p 5901:5900 --net grid --ip 172.0.0.3 -e HUB_HOST=selenium-hub --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug:3.141.59-zinc
 docker run -d -P -p 5902:5900 --net grid --ip 172.0.0.4 -e HUB_HOST=selenium-hub --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-firefox-debug:3.141.59-zinc
```
and open Selenium hub page in browser as explained above. You need to install VNC Viewer and connect to **<ip-address-of-node>:<port-of-node>** where **<ip-address-of-node>** can be taken from the Selenium hub page and **<port-of-node>** is the one specified in the command above with **590x** (the default password is *secret*). 

## Windows

### Create Docker network for Selenium tests
To build the Docker network make sure you have a valid Internet connection and run the commands below:
```shell script
 docker network create --subnet=172.0.0.0/16 grid
 docker run -d -p 4444:4444 --net grid --ip 172.0.0.2 --name selenium-hub selenium/hub:3.141.59-zinc
 
 docker run -d --net grid --ip 172.0.0.3 -e HUB_HOST=selenium-hub -v /c:/dev/shm selenium/node-chrome:3.141.59-zinc
 docker run -d --net grid --ip 172.0.0.4 -e HUB_HOST=selenium-hub -v /c:/dev/shm selenium/node-firefox:3.141.59-zinc
```

### Check the load on the nodes
You need to open Selenium hub page for this. So open in browser: **http://localhost:4444/grid/console**

If you want to open the selenium node containers create the grid with the following commands:
```shell script
 docker network create --subnet=172.0.0.0/16 grid
 docker run -d -p 4444:4444 --net grid --ip 172.0.0.2 --name selenium-hub selenium/hub:3.141.59-zinc
 
 docker run -d -P -p 5901:5900 --ip 172.0.0.3 --net grid -e HUB_HOST=selenium-hub --link selenium-hub:hub -v /c:/dev/shm selenium/node-chrome-debug:3.141.59-zinc
 docker run -d -P -p 5902:5900 --ip 172.0.0.4 --net grid -e HUB_HOST=selenium-hub --link selenium-hub:hub -v /c:/dev/shm selenium/node-firefox-debug:3.141.59-zinc
```
and open Selenium hub page in browser as explained above. You need to install VNC Viewer and connect to **localhost:<port-of-node>** where **<port-of-node>** is the one specified in the command above with **590x** (the default password is *secret*). 

# Running tests in Docker containers with Docker Compose

To build the Docker network make sure you have a valid Internet connection, go to folder where the Docker Compose yaml/yml file is and build the file:
```shell script
cd src/test/resources
docker-compose up -d
```
