
	var wsUri ="ws://192.168.189.181:9000";
	var index=0;
    var output;
	var websocket=null;//global scope

    //interfaces
	function onOpen(evt) {
	
		websocket.send("websocket open");
		websocket.send("cls");
		console.log(evt);
        //doSend(index);
    }
    function onClose(evt) {
       console.log(evt);
    }
    function onMessage(evt) {
       console.log(evt);
       
    }
    function onError(evt) {
		console.log ("socket error");
       
    }
    function doSend(message) {

    }
	////////////////////


	function init(){
	
	console.log ("init");
	websocket= new WebSocket(wsUri);
	
		
	//////////////
	websocket.onopen = function(evt) {
		onOpen(evt)
	};
	websocket.onclose = function(evt) {
		onClose(evt)
	};
	websocket.onmessage = function(evt) {
		onMessage(evt)
	};
	websocket.onerror = function(evt) {
		onError(evt)
	};
		////////////
	
	}
	


    window.addEventListener("load", init, false);

   