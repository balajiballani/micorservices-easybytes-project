# this indicates this micro service needs java 17 to run the service please import 17 into docker image during the
#microservice docker image genaration
FROM openjdk:17-jdk-slim
#tells who is maintining the docker image
MAINTAINER Balaji
#indicates to copy the jar from the below path
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
# this is the command used to run the microservice
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]

#commands
# to run the application -- docker run -p(port) 8080:8080 username/imageName`
# create dockerImage -- docker build .(represents the pathfile since I am having the docker file in the same path
#I am using .) -t(tag) ballanibalaji(docker account username)/(servicename)

#46 on docker has to be rechecked again for better understanding