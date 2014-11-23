#!/bin/sh

export AMITY_ENVIRONMENT=qa

DIRNAME=`dirname $0`
BASENAME=`basename $0`
if [ ! -f $DIRNAME/amity-service.sh ]; then
    ORIGIN_SERVICE_SCRIPT=`readlink $DIRNAME/$BASENAME`
    DIRNAME=`dirname $ORIGIN_SERVICE_SCRIPT`
fi

cd $DIRNAME
./amity-service.sh $@