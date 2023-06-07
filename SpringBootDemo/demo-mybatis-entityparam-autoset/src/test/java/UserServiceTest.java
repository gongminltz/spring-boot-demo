import org.example.mybatis.entityparam.autoset.entity.User;
import org.example.mybatis.entityparam.autoset.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserServiceTest
 *
 * @author gongmin
 * @date 2023/6/6 14:17
 */
public class UserServiceTest extends BaseTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void batchInsertTest() {
        List<User> users = new ArrayList<>(2);
        User user1 = new User();
        user1.setId("1");
        user1.setName("gongmin");
        user1.setCreateDate(new Date());
        user1.setModifyDate(user1.getCreateDate());
        user1.setAddress("changsha");
        user1.setPhone("1888888888");
        user1.setSex("男");
        users.add(user1);

        user1 = new User();
        user1.setId("2");
        user1.setName("lily");
        user1.setCreateDate(new Date());
        user1.setModifyDate(user1.getCreateDate());
        user1.setAddress("changsha");
        user1.setPhone("1888888888");
        user1.setSex("女");
        users.add(user1);

        userMapper.batchInsert(users);
    }

    @Test
    public void batchUpdateByPrimaryKeySelective() {
        List<User> users = new ArrayList<>(2);
        User user1 = new User();
        user1.setId("1");
        user1.setName("gongmasdfin2");
        user1.setCreateDate(new Date());
        user1.setModifyDate(user1.getCreateDate());
        user1.setAddress("chasdfangsh1a");
        user1.setPhone("189784asdf88888888");
        user1.setSex("男");
        users.add(user1);

        user1 = new User();
        user1.setId("2");
        user1.setName("lisdfly2");
        user1.setCreateDate(new Date());
        user1.setModifyDate(user1.getCreateDate());
        user1.setAddress("changasdfsha1");
        user1.setSex("女");
        users.add(user1);

        userMapper.batchUpdateByPrimaryKeySelective(users);
    }

    @Test
    public void insertSelective() {
        User user1 = new User();
        user1.setId("1");
        user1.setName("gongmin2");
        user1.setCreateDate(new Date());
        user1.setModifyDate(user1.getCreateDate());
        user1.setAddress("changsh1a");

        userMapper.insertSelective(user1);
    }
}
