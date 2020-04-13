@echo off

echo Collecting version info...
call :versions >versions.log

echo Installing system image...
call %ANDROID_HOME%\tools\bin\sdkmanager --install "system-images;android-10;default;x86" >avd_install.log

echo Creating virtual device...
call %ANDROID_HOME%\tools\bin\avdmanager --verbose create avd --force --name "issue_153828700" --package "system-images;android-10;default;x86" --tag "default" --abi "x86" --device "Nexus S" >avd_create.log

echo Restarting ADB...
%ANDROID_HOME%\platform-tools\adb kill-server
%ANDROID_HOME%\platform-tools\adb start-server

echo Collecting logcat in background...
start /b "Collecting logcat" "%ANDROID_HOME%\platform-tools\adb" logcat -v threadtime > logcat.log

echo Manually execute: adb shell top -n 3 ^> adb-shell-top.log

echo Starting emulated device... (CTRL+C to request emulator death, then wait a bit)
%ANDROID_HOME%\emulator\emulator -avd "issue_153828700" -verbose -show-kernel -no-snapshot >emulator-run.log 2>&1

goto :EOF


:versions

echo Versions
echo.
echo.

echo systeminfo
systeminfo | find "OS"
systeminfo | find "System"
echo.

echo sdkmanager
call %ANDROID_HOME%\tools\bin\sdkmanager.bat --version
echo.

echo tools (avdmanager)
rem `avdmanager -version` is not a thing
call %ANDROID_HOME%\tools\bin\sdkmanager.bat --list | find "  tools"
echo.

echo platform-tools (adb)
call %ANDROID_HOME%\tools\bin\sdkmanager.bat --list | find "  platform-tools"
echo.

echo emulator
%ANDROID_HOME%\emulator\emulator -version
call %ANDROID_HOME%\tools\bin\sdkmanager.bat --list | find "  emulator"
echo.

exit /b 0
