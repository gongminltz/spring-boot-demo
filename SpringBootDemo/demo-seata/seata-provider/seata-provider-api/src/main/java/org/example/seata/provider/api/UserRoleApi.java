package org.example.seata.provider.api;

import org.example.seata.provider.dto.UserRoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserRoleApi
 *
 * @author gongmin
 * @date 2022/10/26 14:37
 */
@FeignClient(value = "seata-provider", contextId = "UserRoleApi")
@RequestMapping("/userRole")
public interface UserRoleApi {
    @PostMapping("insert")
    void insert(@RequestBody UserRoleDto userRoleDto);
}
