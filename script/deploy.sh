#!/bin/bash
LASTRUNER=`docker ps -q -f name=$PACKAGENAME`
if [ -n "$LASTRUNER" ]; then
    docker kill $LASTRUNER
fi
docker run --rm --name $PACKAGENAME -p $RUNPORT:8080 $PACKAGENAME:$BUILD_TAG
