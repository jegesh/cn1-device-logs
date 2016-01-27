# cn1-device-logs
A Codenameone library for gaining access to native device system logs

Supported Operating Systems
---------------------------
Currently only Android is supported.  Contributions are welcome!

Installation
------------
1. Download the project onto your machine, into a directory separate from your cn1 project
2. Build the project in NetBeans
3. Copy the .jar file that has now appeared in the dist directory to the lib directory in your cn1 project
4. Right-click on the cn1 project and select Codename One > Refresh cn1lib files

Usage
-----
There's only one method, and it's static.  It has two different signatures, with no arguments or setting the number of lines you want to return from the system error logs.  The default is 150.

`String log = SystemLogsUtil.getSysErrorLogs();`

`String log = SystemLogsUtil.getSysErrorLogs(250);`
