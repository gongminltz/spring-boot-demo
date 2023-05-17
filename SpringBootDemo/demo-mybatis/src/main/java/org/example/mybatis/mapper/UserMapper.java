package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:46
 */
//@CacheNamespace(flushInterval = 60000)
public interface UserMapper extends Mapper<User> {
    /**
     * 通过电话号码获取
     *
     * @param phone 电话号码
     * @return 用户信息
     */
    List<User> getByPhone(@Param("phone") String phone);
}
