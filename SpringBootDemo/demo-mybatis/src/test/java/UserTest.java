import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mybatis.entity.User;
import org.example.mybatis.entity.UserRole;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.mapper.UserRoleMapper;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserTest
 *
 * @author gongmin
 * @date 2022/12/27 14:49
 */
public class UserTest extends BaseTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private SqlSessionFactory sessionFactory;

    @Test
    public void writeData() {
        String[] sexArray = {"男", "女"};
        Long[] roleId = {1l, 2l, 3l, 4l};

        User user = new User();
        UserRole userRole = new UserRole();

        for (long i = 1; i <= 500000; i++) {
            logger.info("<writeData> i = " + i);
            user.setId(i + 1);
            user.setName("name" + i);
            user.setSex(sexArray[i % 10 < 8 ? 0 : 1]);
            user.setPhone("phone" + i);
            user.setAddress("address" + i);
            userMapper.insert(user);

            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId[(int) (i % 4)]);
            userRoleMapper.insert(userRole);
        }
    }

    /**
     * mybatis一级缓存测试
     */
    @Test
    public void firstLevelCacheTest() {
        SqlSession sqlSession1 = sessionFactory.openSession();
        SqlSession sqlSession2 = sessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = userMapper1.selectByPrimaryKey(2);
        sqlSession1.commit();

        User user2 = userMapper2.selectByPrimaryKey(2);
        sqlSession2.commit();

        if (user1 == user2) {
            logger.info("user1 == user2");
        } else {
            logger.info("user1 != user2");
        }
    }

    @Test
    @Transactional
    public void firstLevelCacheTest2() {
        User user1 = userMapper.selectByPrimaryKey(2);
        User user2 = userMapper.selectByPrimaryKey(2);
    }
}
