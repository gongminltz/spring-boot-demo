package org.example.feign.client.third;

import org.example.feign.client.dto.GetAccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HkwsApi
 *
 * @author gongmin
 * @date 2022/10/20 17:10
 */
@FeignClient(name = "HkwsApi", url = "${hkws.url}", configuration = FeignFormSupportConfig.class)
@RequestMapping("/api/lapp")
public interface HkwsApi {
    /**
     * 获取accessToken
     *
     * @param appKey    appKey
     * @param appSecret appSecret
     * @return 返回值
     */
    @PostMapping(value = "/token/get",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    GetAccessTokenResponse getAccessToken(@RequestParam("appKey") String appKey,
                                          @RequestParam("appSecret") String appSecret);
}
