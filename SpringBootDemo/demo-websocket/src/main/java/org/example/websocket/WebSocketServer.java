package org.example.websocket;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.websocket.config.WebSocketEncode;
import org.example.websocket.request.GetProgressRequestParam;
import org.example.websocket.response.GetProgressResponse;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocketServer
 *
 * @author gongmin
 * @date 2022/11/15 9:53
 */
@ServerEndpoint(value = "/websocket/getProgress", encoders = WebSocketEncode.class)
@Component
@Slf4j
public class WebSocketServer {
    private static final JsonMapper JSON_MAPPER = new JsonMapper();

    private int progress = 0;

    /**
     * 建立连接
     *
     * @param session session
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("<onOpen> start");
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        log.info("<onClose> start");
    }

    /**
     * 收到客户端消息
     *
     * @param message 消息内容
     * @param session session
     */
    @OnMessage
    public void onMessage(String message, Session session) throws EncodeException, IOException {
        log.info("<onMessage> message = " + message);

        GetProgressRequestParam progressRequestParam = JSON_MAPPER.readValue(message, GetProgressRequestParam.class);
        GetProgressResponse response = GetProgressResponse.builder()
                .userId(progressRequestParam.getUserId())
                .progress(progress++)
                .build();

        session.getBasicRemote().sendObject(response);
    }
}
