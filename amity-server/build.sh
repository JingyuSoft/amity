#!/bin/sh

cd `dirname $0`

rm -rf ../deploy
mkdir ../deploy

mvn package

cp -rfv 
