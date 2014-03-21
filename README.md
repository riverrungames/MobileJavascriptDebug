MobileJavascriptDebug
=====================

Run javascript on mobile device and debug on computers

Dependency:

Netty 4.x
Browser Websocket support {http://www.websocket.org/echo.html to test it!}

Howto:

1. Run this programme on your computer. 
2. Rewrite you html to include debug.js [this js will init websocket for you].
3. Use websocket.send(msg) to transfer you debug msg to your computer.
	It's highly recommended to use a log manager to control all log transfer. 