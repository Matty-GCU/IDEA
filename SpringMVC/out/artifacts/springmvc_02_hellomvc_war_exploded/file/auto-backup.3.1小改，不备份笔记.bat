cd C:\006ProjectFile\Ǩ����Ŀ\myBlog
git add .
git commit -m "%date% common backup"
git push github

@echo.
@echo.
@echo.
cd C:\Users\Matty's PC\IdeaProjects
git add .
git commit -m "%date% common backup"
git push github

@echo off
echo.
echo ����� Blog ^& IDEA ���ݣ�
echo �Ƿ���� Eclipse ^& PHPStorm ^& MyEclipse ��
echo �������ȷ��...
pause >nul
@echo on

cd C:\eclipse-java-mars-win32\workspace
git add .
git commit -m "%date% common backup"
git push github

@echo.
@echo.
@echo.
cd C:\Users\Matty's PC\PhpStormProjects
git add .
git commit -m "%date% common backup"
git push github

@echo.
@echo.
@echo.
cd C:\Users\Matty's PC\Workspaces\MyEclipse 2016 CI
git add .
git commit -m "%date% common backup"
git push github

@echo off
echo.
echo ����� Eclipse ^& PHPStorm ^& MyEclipse ���ݣ�
echo ��������˳�...
pause >nul