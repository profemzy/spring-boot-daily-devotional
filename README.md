#### Daily Devotional Web Application and Web Service(REST) with Docker, Spring Boot and MYSQL Backend built with MAVEN

Powered by [Femi Oladele](https://www.linkedin.com/in/profemzy/)

DOCKER
--------
CREATE .ENV AND EDIT PARAMETERS AS DESIRED

cp .env.example .env

BUILD THE DB IMAGE

docker build -t db db

RUN DATABASE WITH 

docker run --detach --name=db -p 3308:3306 --env-file ./.env  db

BUILD APP

docker build -t daily-devotional .

RUN APP

docker run --name=daily-devotional -p 8080:8080 --env-file ./.env  --link db:mysql -d daily-devotional


CHECK LOGS

docker logs daily-devotional