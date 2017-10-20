FROM maven:3-alpine

RUN mkdir -p "~/webapps"
COPY javatest.war "~/webapps" 
CMD [ "java", "-jar","~/webapps/javatest.war" ]