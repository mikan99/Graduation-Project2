FROM eclipse-temurin:21-jdk
RUN apt-get update && apt-get install -y \
    curl git unzip
RUN mkdir -p /graduation
ENV GRADLE_VERSION=8.6
RUN curl -sSL https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle.zip \
    && unzip gradle.zip -d /opt \
    && mv /opt/gradle-${GRADLE_VERSION} /opt/gradle \
    && ln -s /opt/gradle/bin/gradle /usr/bin/gradle \
    && rm gradle.zip
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${PATH}:/opt/gradle/bin"