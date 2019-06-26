FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
RUN wget http://search.maven.org/remotecontent?filepath=org/jolokia/jolokia-jvm/1.6.2/jolokia-jvm-1.6.2-agent.jar -O /app/jolokia.jar
EXPOSE 7777
ENTRYPOINT ["java", "-javaagent:/app/jolokia.jar=port=7777,host=0.0.0.0", "-cp","app:app/lib/*","com.joshjconlin.monitoring.Application"]
