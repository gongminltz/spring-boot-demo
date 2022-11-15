package org.example.websocket.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * WebSocketEncode
 *
 * @author gongmin
 * @date 2022/11/15 10:41
 */
public class WebSocketEncode implements Encoder.Text<Object> {
    private static final JsonMapper JSON_MAPPER = new JsonMapper();

    @SneakyThrows
    @Override
    public String encode(Object o) throws EncodeException {
        return JSON_MAPPER.writeValueAsString(o);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
