#!/bin/sh
DIR="$( cd "$( dirname "$0" )" && pwd )"
gradle_version_url="https://services.gradle.org/distributions/gradle-8.7-bin.zip"
echo "Descargando Gradle Wrapper..."
./gradlew "$@"
