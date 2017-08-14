#!/bin/bash
docker stop bpserver || true
docker rm bpserver || true
pwd
ls -la

docker build -t bpserver:latest .
docker run --name bpserver -p 8082:8080 -d -it bpserver:latest
docker exec -d bpserver service postgresql start
docker exec -d bpserver service tomcat8 start
