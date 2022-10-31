package org.example.dm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.dm.entity.User;

import java.util.List;

/**
 * 用户表
 *
 * @author gongmin
 * @date 2022/10/17 15:46
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过电话号码获取
     *
     * @param phone 电话号码
     * @return 用户信息
     */
    List<User> getByPhone(@Param("phone") String phone);
}
