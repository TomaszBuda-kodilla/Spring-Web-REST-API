call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo RUNCRUD.bat has errors - breaking work
goto fail

:browser
start "CHROME" "C:\Program Files (x86)\Google\Chrome\Application\chrome" "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Chrome doesn't work properly.
goto fail

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.