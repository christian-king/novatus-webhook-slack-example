#!/bin/bash

# If port is not defined default to 5000 for the default ELB uses on
# Elastic Beanstalk
if [ -z "$PORT" ]; then
    PORT=5000
fi

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

java $JAVA_OPTS -jar $DIR/jetty-runner.jar --port $PORT $DIR/*.war
