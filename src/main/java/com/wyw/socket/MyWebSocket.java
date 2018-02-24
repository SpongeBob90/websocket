package com.wyw.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wyw
 * @date 2018\2\24 0024 13:48
 */
@Component
@ServerEndpoint(value = "/websocket")
public class MyWebSocket {

    private static Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

    /**
     * 用来存储不同客户端的WebSocket对象
     */
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 当前会话
     */
    private Session session;

    /**
     * 成功建立连接后调用该方法
     * @param session session对象
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        this.session.getAsyncRemote().sendText("加入群聊，当前在线人数："+webSocketSet.size());
    }

    /**
     * 当连接关闭后调用该方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        this.session.getAsyncRemote().sendText("退出群聊");
    }

    /**
     * 当连接发生错误时调用该方法
     * @param error 错误信息
     */
    @OnError
    public void onError(Throwable error){
        webSocketSet.remove(this);
        logger.error(error.getMessage());
    }

    /**
     * 当收到客户端发来的消息时调用该方法
     * @param message 消息
     */
    @OnMessage
    public void onMessage(String message){
        broadCast(message);
    }

    private void broadCast(String message){
        for (MyWebSocket socket : webSocketSet){
            socket.session.getAsyncRemote().sendText(message);
        }
    }

}
