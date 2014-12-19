REM @echo off

cd /d %~dp0
echo %cd%

set THRIFT=..\..\lib\thrift-0.9.2.exe
set SRC_DIR=..\..\src\main\resources\thrift

set JAVA_DST_DIR=..\..\src\main\java
set IOS_DST_DIR=..\..\..\amity-app\thrift

del /S /y %JAVA_DST_DIR%\com\jingyusoft\amity\thrift\generated

for /R %SRC_DIR% %%G in (*.thrift) do (
	%THRIFT% --gen java -out %JAVA_DST_DIR% %%G
	%THRIFT% --gen cocoa -out %IOS_DST_DIR% %%G
)

pause