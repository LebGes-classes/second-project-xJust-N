@echo off
setlocal

java -classpath "out/production/second-project-xJust-N/src" "Main"

pause
rmdir /s /q "bin"
endlocal