package org.example.pagehelper.service;

import com.github.pagehelper.PageInfo;
import org.example.pagehelper.entity.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
public interface UserService {
    /**
     * 通过名称查找
     *
     * @param pageNum 页码，从1开始
     * @param pageSize 每页个数
     * @return 用户列表
     */
    PageInfo<User> getList(int pageNum, int pageSize);
}
