package org.example.nacos.provider.controller;

import org.example.nacos.provider.api.UserApi;
import org.example.nacos.provider.dto.UserDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author gongmin
 * @date 2022/10/19 17:18
 */
@RestController
public class UserController implements UserApi {
    @Override
    public UserDto getUser(String id) {
        return UserDto.builder()
                .id(id)
                .name("gongmin")
                .phone("1234")
                .build();
    }
}
