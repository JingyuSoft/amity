#!/bin/sh

DIRNAME=`dirname $0`
BASENAME=`basename $0`
if [ ! -f $DIRNAME/amity-service.sh ]; then
    echo "+++++++++++++++"
    ORIGIN_SERVICE_SCRIPT=`readlink $DIRNAME/$BASENAME`
    echo $ORIGIN_SERVICE_SCRIPT
    echo "---------------"
    DIRNAME=`dirname $ORIGIN_SERVICE_SCRIPT`
fi

cd $DIRNAME
./amity-service.sh qa