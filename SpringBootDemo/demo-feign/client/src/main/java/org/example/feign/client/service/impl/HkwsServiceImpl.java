package org.example.feign.client.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.feign.client.dto.GetAccessTokenResponse;
import org.example.feign.client.service.HkwsService;
import org.example.feign.client.third.HkwsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * HkwsServiceImpl
 *
 * @author gongmin
 * @date 2022/10/21 8:41
 */
@Slf4j
@Service
public class HkwsServiceImpl implements HkwsService {
    private static final JsonMapper jsonMapper = new JsonMapper();

    @Value("${hkws.appKey}")
    private String appKey;

    @Value("${hkws.secret}")
    private String secret;

    @Resource
    private HkwsApi hkwsApi;

    @Override
    public String getAccessToken() {
        GetAccessTokenResponse response = hkwsApi.getAccessToken(appKey, secret);

        try {
            log.info("<getAccessToken> response = " + jsonMapper.writeValueAsString(response));
            if (!response.isSucceed()) {
                return null;
            }

            return response.getData().getAccessToken();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
