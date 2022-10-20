package org.example.feign.client.third;

import org.example.feign.client.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户接口
 *
 * @author gongmin
 * @date 2022/10/20 8:41
 */
@FeignClient(name = "UserApi", url = "${demo.mybatis.serverUrl}")
@RequestMapping("/user")
public interface MybatisUserApi {
    /**
     * 根据用户名自来获取用户信息
     *
     * @param name 用户名自
     * @return 用户信息列表
     */
    @GetMapping("/getByName")
    List<User> getByName(@RequestParam("name") String name);
}
