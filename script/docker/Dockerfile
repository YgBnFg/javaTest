FROM maven:3-alpine

RUN mkdir -p "~/webapps"
COPY javatest.war "~/webapps" 
ENTRYPOINT [ "java", "-jar","~/webapps/javatest.war" ]