cd /d %~dp0

del /y ..\..\src\main\java\com\jingyusoft\amity\common\ErrorCodes.java

python error_code.py error_code.txt ..\..\src\main\java\com\jingyusoft\amity\common\ErrorCodes.java

pause