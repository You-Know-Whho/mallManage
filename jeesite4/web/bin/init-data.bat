@echo off
rem /**
rem  * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
rem  *
rem  * Author: ThinkGem@163.com
rem  */
echo.
echo [��Ϣ] ��ʼ�����ݿ⣬�����������
echo.
pause
echo.
echo [��Ϣ] �˲�������������������ݱ����ָ���ʼ״̬��
echo.
echo [��Ϣ] ȷ�ϼ����𣿷�����رմ��ڡ���5��
echo.
pause
echo.
echo [��Ϣ] �����ȷ�ϼ����𣿷�����رմ��ڡ���4��
echo.
pause
echo.
echo [��Ϣ] �����ȷ�ϼ����𣿷�����رմ��ڡ���3��
echo.
pause
echo.
echo [��Ϣ] �����ȷ�ϼ����𣿷�����رմ��ڡ���2��
echo.
pause
echo.
echo [��Ϣ] �����ȷ�ϼ����𣿷�����رմ��ڡ���1��
echo.
pause
echo.

%~d0
cd %~dp0

cd ..
set "MAVEN_OPTS=%MAVEN_OPTS% -Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m"
call mvn clean test -Dmaven.test.skip=false -Dtest=com.jeesite.test.InitData -Djeesite.initdata=true -U

cd bin
cmd /c msg %username% /time:0 /w "��ʼ�����ݿ����..."
pause