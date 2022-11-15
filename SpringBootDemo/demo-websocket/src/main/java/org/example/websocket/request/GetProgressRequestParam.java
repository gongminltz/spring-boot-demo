package org.example.websocket.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 获取进度请求参数
 *
 * @author gongmin
 * @date 2022/11/15 10:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProgressRequestParam implements Serializable {
    /**
     * 用户id
     */
    private String userId;
}
