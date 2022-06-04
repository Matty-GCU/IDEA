cd C:\006ProjectFile\迁移项目\myBlog
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
echo 已完成 Blog ^& IDEA 备份！
echo 是否进行 Eclipse ^& PHPStorm ^& MyEclipse ？
echo 按任意键确认...
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
echo 已完成 Eclipse ^& PHPStorm ^& MyEclipse 备份！
echo 按任意键退出...
pause >nul