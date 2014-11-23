#!/bin/sh

cd `dirname $0`

rm -rfv target/

mvn package

cp scripts/service/* target/appassembler/bin
chmod +x target/appassembler/bin/*
