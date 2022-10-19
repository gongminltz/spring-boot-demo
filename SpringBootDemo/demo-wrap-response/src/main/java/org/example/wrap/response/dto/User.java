package org.example.wrap.response.dto;

import lombok.Builder;
import lombok.Data;

/**
 * User
 *
 * @author gongmin
 * @date 2022/10/19 11:50
 */
@Data
@Builder
public class User {
    private String id;
    private String name;
    private String phone;
}
