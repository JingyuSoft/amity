REM @echo off

cd /d %~dp0
echo %cd%

set THRIFT=..\..\lib\thrift-0.9.2.exe
set SRC_DIR=..\..\src\main\resources\thrift

set JAVA_DST_DIR=..\..\src\main\java
set IOS_DST_DIR=..\..\..\amity-app\thrift

%THRIFT% --gen java -out %JAVA_DST_DIR% %SRC_DIR%\amity.thrift
%THRIFT% --gen cocoa -out %IOS_DST_DIR% %SRC_DIR%\amity.thrift

pause