@echo off
setlocal enabledelayedexpansion

REM Comprobar si se recibe entrada por redirección o teclado
set "text_to_check="
for /f "tokens=*" %%a in ('more') do (
    if defined text_to_check (
        set "text_to_check=!text_to_check! %%a"
    ) else (
        set "text_to_check=%%a"
    )
)

if "%text_to_check%"=="" (
    set /p "text_to_check=Introduce el texto en español para corregir: "
)

REM Si se usa Hunspell para Windows en el PATH, se puede invocar directamente.
REM En su defecto, mostramos/devolvemos el texto recibido para el flujo de datos:
echo %text_to_check%