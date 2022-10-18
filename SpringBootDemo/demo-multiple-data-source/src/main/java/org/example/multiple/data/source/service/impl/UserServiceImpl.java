package org.example.multiple.data.source.service.impl;

import org.example.multiple.data.source.entity.User;
import org.example.multiple.data.source.entity.UserRole;
import org.example.multiple.data.source.mapper.gm2.Gm2UserMapper;
import org.example.multiple.data.source.mapper.gm2.UserRoleMapper;
import org.example.multiple.data.source.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务
 *
 * @author gongmin
 * @date 2022/10/17 15:49
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private Gm2UserMapper gm2UserMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User getById(String id) {
        return gm2UserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByName(String name) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", name);

        return gm2UserMapper.selectByExample(example);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return gm2UserMapper.getByPhone(phone);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, value = "gm2TransactionManager")
    public void addUserAndSetRole(String userName, String phone, String address, String roleId) {
        logger.info("<addUserAndSetRole> userName = {}, phone = {}, address = {}, roleId = {}",
                userName, phone, address, roleId);

        String userId = "2" + roleId;

        // 新增用户
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setPhone(phone);
        user.setAddress(address);

        gm2UserMapper.insert(user);

        // 配置用户角色
        UserRole userRole = new UserRole();
        userRole.setId("1");
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);

        userRoleMapper.insert(userRole);
    }
}
