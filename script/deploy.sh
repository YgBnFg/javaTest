#!/bin/bash
LASTRUNER=`docker ps -q -f name=$PACKAGENAME`
if [ -n "$LASTRUNER" ]; then
    docker kill $LASTRUNER
    echo "kill $LASTRUNER"
fi


docker run --rm -d --name $PACKAGENAME -p $RUNPORT:8080 $PACKAGENAME:$BUILD_TAG
echo "run $PACKAGENAME:$BUILD_TAG"
