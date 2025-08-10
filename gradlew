#!/usr/bin/env sh
#
# Gradle start up script for UN*X
#

##############################################################################
# This script executes Gradle in a controlled environment.
##############################################################################

# Determine the location of the script
PRG="$0"

while [ -h "$PRG" ] ; do
  ls=$(ls -ld "$PRG")
  link=$(expr "$ls" : '.*-> \(.*\)$')
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=$(dirname "$PRG")/"$link"
  fi
done

PRGDIR=$(dirname "$PRG")

exec "$PRGDIR"/gradle/wrapper/gradle-wrapper.jar "$@"
