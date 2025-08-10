@echo off
rem -----------------------------------------------------------------------------
rem Gradle start up script for Windows
rem -----------------------------------------------------------------------------

set DIRNAME=%~dp0
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

set GRADLE_WRAPPER_JAR=%APP_HOME%gradle\wrapper\gradle-wrapper.jar
set GRADLE_WRAPPER_PROPERTIES=%APP_HOME%gradle\wrapper\gradle-wrapper.properties

if not exist "%GRADLE_WRAPPER_JAR%" (
    echo ERROR: Gradle wrapper jar not found.
    exit /b 1
)

java -jar "%GRADLE_WRAPPER_JAR%" %*
