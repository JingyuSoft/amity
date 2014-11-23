#!/bin/sh

if [ -z $AMITY_ENVIRONMENT ]; then
	echo "AMITY_ENVIRONMENT not specified. Existing..."
	exit 1
fi

cd `dirname $0`

SERVICE_NAME=amity-service-$AMITY_ENVIRONMENT
START_SCRIPT=amity-server-$AMITY_ENVIRONMENT.sh
TEMP_DIR=/var/tmp/jingyusoft
PID_PATH_NAME=$TEMP_DIR/${SERVICE_NAME}-pid
OUTPUT_FILE_NAME=$TEMP_DIR/$SERVICE_NAME/output.log

echo "Service Name     = " $SERVICE_NAME
echo "Start Script     = " $START_SCRIPT
echo "Temp Dir         = " $TEMP_DIR
echo "PID_PATH_NAME    = " $PID_PATH_NAME
echo "OUTPUT_FILE_NAME = " $OUTPUT_FILE_NAME

if [ ! -d $TEMP_DIR/$SERVICE_NAME ]; then
	mkdir -p $TEMP_DIR/$SERVICE_NAME
	echo "Temp directory created: " $TEMP_DIR/$SERVICE_NAME 
fi

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            $START_SCRIPT >> $OUTPUT_FILE_NAME 2>&1 &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            $START_SCRIPT >> $OUTPUT_FILE_NAME 2>&1 &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac 