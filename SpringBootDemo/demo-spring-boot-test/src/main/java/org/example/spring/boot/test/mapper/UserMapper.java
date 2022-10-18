package org.example.spring.boot.test.mapper;

import org.example.spring.boot.test.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:46
 */
public interface UserMapper extends Mapper<User> {
}
