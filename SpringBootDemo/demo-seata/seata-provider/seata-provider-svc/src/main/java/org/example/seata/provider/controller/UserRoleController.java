package org.example.seata.provider.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.seata.provider.api.UserRoleApi;
import org.example.seata.provider.dto.UserRoleDto;
import org.example.seata.provider.entity.UserRole;
import org.example.seata.provider.service.UserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserRoleController
 *
 * @author gongmin
 * @date 2022/10/26 14:40
 */
@Slf4j
@RestController
public class UserRoleController implements UserRoleApi {
    private static final JsonMapper jsonMapper = new JsonMapper();

    @Resource
    private UserRoleService userRoleService;

    @Override
    public void insert(UserRoleDto userRoleDto) {
        try {
            log.info("<insert> " + jsonMapper.writeValueAsString(userRoleDto));
            UserRole userRole = new UserRole();
            BeanUtils.copyProperties(userRoleDto, userRole);
            userRoleService.insert(userRole);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
