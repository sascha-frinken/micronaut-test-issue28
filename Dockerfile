FROM openjdk:8-jdk-alpine 
RUN apk --no-cache add curl
COPY build/libs/*.jar test-transactional-service.jar
CMD java ${JAVA_OPTS} -jar test-transactional-service.jar