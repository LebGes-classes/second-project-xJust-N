@echo off
setlocal

javac -sourcepath "src" -d "bin" "src\Main.java"
java -classpath "bin" "Main"

pause
rmdir /s /q "bin"
endlocal