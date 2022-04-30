set projectLocation=C:\Users\Naa Property\git\JupitorToys\PlanIT_Automation_Test
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause