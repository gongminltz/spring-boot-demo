package org.example.seata.provider.dto;

import lombok.Builder;
import lombok.Data;

/**
 * UserRoleDto
 *
 * @author gongmin
 * @date 2022/10/26 14:35
 */
@Data
@Builder
public class UserRoleDto {
    private String id;
    private String userId;
    private String roleId;
}
