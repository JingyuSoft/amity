#!/bin/sh

cd `dirname $0`

rm -rfv target/

mvn package

cp scripts/service/* target/appassembler/bin
chmod +x target/appassembler/bin/*

if [ ! -L /etc/init.d/amity-service-qa ]; then
	echo "Registering amity-service-qa as Linux service..."
	sudo ln -s target/appassembler/bin/amity-service-qa /etc/init.d/amity-service-qa
else
	echo "amity-service-qa already registered as Linux service"
fi
