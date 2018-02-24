var socket;

function enterChatRoom() {
    if ("WebSocket" in window) {
        socket = new WebSocket("ws://localhost:8080/websocket");
        socket.onopen = function (event) {
            addMsgToList("LOC MSG：连接成功");
        };
        socket.onclose = function (event) {
            addMsgToList("LOC MSG：连接关闭");
        };
        socket.onerror = function (event) {
            addMsgToList("LOC MSG：连接异常");
        };
        socket.onmessage = function (event) {
            addMsgToList(event.data);
        };
    } else {
        addMsgToList("Not support WebSocket.");
        return false;
    }
}

function addMsgToList(msg) {
    var msgList = document.getElementById("msgList");
    msgList.innerHTML += msg + "<br/>";
}

function exitChatRoom() {
    
}

function sendMsg() {
    var msg = document.getElementById("msg").value;
    socket.send(msg);
}