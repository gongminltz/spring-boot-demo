package org.example.mongodb.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mongodb.constants.CollectionKey;
import org.example.mongodb.entity.User;
import org.example.mongodb.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author gongmin
 * @date 2022/11/4 15:04
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        log.info("<insert> start");

        if (user.getCreateTime() == null) {
            user.setCreateTime(LocalDateTime.now());
        }

        mongoTemplate.insert(user);
    }

    @Override
    public List<User> findByName(String name) {
        Criteria criteria = new Criteria();
        criteria.and(CollectionKey.NAME).is(name);

        Query query = new Query(criteria);

        return mongoTemplate.find(query, User.class);
    }
}
