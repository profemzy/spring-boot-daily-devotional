FROM amd64/openjdk:13.0.2-jdk-buster

COPY ./target/dailydevotional-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch dailydevotional-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","dailydevotional-0.0.1-SNAPSHOT.jar"]