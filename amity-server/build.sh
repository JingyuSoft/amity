#!/bin/sh

cd `dirname $0`

rm -rfv target/

mvn package
