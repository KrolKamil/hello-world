@echo off

:start
echo ### MENU ###
echo Wybierz ktory skrypt chesz wykonac:
echo START - 1
echo INFORMACJE - 2
echo BACKUP - 3
echo ZAKONCZ - 4
set /p x=Wyprwoadz liczbe: 
if %x%==1 GOTO a
if %x%==2 GOTO b
if %x%==3 GOTO c
if %x%==4 GOTO exit
cls
GOTO start

:a
cls
echo Skrypt a
pause
cls
GOTO start

:b
cls
echo 			***Liczby B-gladkie***
echo.
echo Program rozwiazuje zadanie konkursowe z algorytmionu
echo.
echo Algorytm ma za zadanie znajdywanie liczb B-gladkich na danych przedzialach
echo.
echo Przedzialy oraz liczba b jest podawana w pierwszej linicje pliku
echo.
echo Wyniki pracy alkorytmu zostaja opisane w witrynie internetowej
echo.
echo Szczegolowy opis rozwiazania znajduje sie w dokumetacji
echo.

pause
cls
GOTO start

:c
cls
echo Backup

SET mypath=%~dp0
SET source=%mypath:~0,-1%
cd..
mkdir backup
SET dest=%cd%\backup
cd %source%
xcopy %source% %dest% /s /i

pause
cls
GOTO start

:exit
cls
echo Koniec
pause
echo on
