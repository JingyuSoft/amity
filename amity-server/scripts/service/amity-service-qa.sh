#!/bin/sh

DIRNAME=`dirname $0`
BASENAME=`basename $0`
if [ ! -f $DIRNAME/amity-service.sh ]; then
	DIR_NAME=`readlink $DIR_NAME/$BASENAME`
fi

cd $DIR_NAME
./amity-service.sh qa
