package org.example.feign.client.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 获取accessToken返回参数
 *
 * @author gongmin
 * @date 2022/10/20 17:15
 */
@Data
public class GetAccessTokenResponse extends HkwsBaseResponse {
    private Data data;

    @Getter
    @Setter
    public static class Data {
        /**
         * accessToken
         */
        private String accessToken;

        /**
         * 具体过期时间，精确到毫秒
         */
        private Long expireTime;
    }
}
