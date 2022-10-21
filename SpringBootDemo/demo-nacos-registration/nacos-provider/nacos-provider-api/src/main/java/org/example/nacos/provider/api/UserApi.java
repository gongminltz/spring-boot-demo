package org.example.nacos.provider.api;

import org.example.nacos.provider.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户接口
 *
 * @author gongmin
 * @date 2022/10/19 16:08
 */
@FeignClient(value = "demo-nacos-provider", contextId = "UserApi")
@RequestMapping("/user")
public interface UserApi {
    /**
     * 通过id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUser")
    UserDto getUser(@RequestParam("id") String id);
}
