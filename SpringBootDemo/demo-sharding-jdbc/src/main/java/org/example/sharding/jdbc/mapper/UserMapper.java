package org.example.sharding.jdbc.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.sharding.jdbc.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:46
 */
public interface UserMapper extends Mapper<User> {
    /**
     * 通过id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User selectById(@Param("id") Integer id);
}
