@echo off
rem /**
rem  * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
rem  *
rem  * Author: ThinkGem@163.com
rem  */
echo.
echo [��Ϣ] ���Web���̣����뵽Docker����
echo.

%~d0
cd %~dp0

cd ..
call mvn clean package docker:build -Dmaven.test.skip=true -U -Pdocker

cd bin
cmd /c msg %username% /time:0 /w "������..."
pause