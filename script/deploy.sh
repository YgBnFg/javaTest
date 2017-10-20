#!/bin/bash
LASTRUNER=`docker ps -q -f name=$PACKAGENAME`
if [ -n "$LASTRUNER" ]; then
    docker kill $LASTRUNER
    echo "kill $LASTRUNER"
fi

if [ -n "${1}" ]; then
    PROFILES=${1}
    echo "profiles are active: $PROFILES"
fi

docker run --rm -d --name $PACKAGENAME -p $RUNPORT:8080 $PACKAGENAME:$BUILD_TAG --spring.profiles.active=$PROFILES
echo "run $PACKAGENAME:$BUILD_TAG"
