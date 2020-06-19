@echo off
set plugin_path=c:\Users\zyl\AppData\Local\Wox\app-1.4.1196\Plugins\Zyl.Jenkins\
copy plugin.json %plugin_path%
copy main.py  %plugin_path%
copy install-requirements.bat  %plugin_path%
call mvn clean package
echo copying jar...
copy target\wox.jar %plugin_path%