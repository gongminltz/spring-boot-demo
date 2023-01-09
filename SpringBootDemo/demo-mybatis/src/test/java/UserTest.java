import org.example.mybatis.entity.User;
import org.example.mybatis.entity.UserRole;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.mapper.UserRoleMapper;
import org.junit.Test;

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

    @Test
    public void writeData() {
        String[] sexArray = {"男", "女"};
        Long[] roleId = {1l, 2l, 3l, 4l};

        User user = new User();
        UserRole userRole = new UserRole();

        for (long i = 1; i <= 500000; i++) {
            logger.info("<writeData> i = " + i);
            user.setId(i + 1);
            user.setName("name" +i);
            user.setSex(sexArray[i % 10 < 8 ? 0 : 1]);
            user.setPhone("phone" +i);
            user.setAddress("address" + i);
            userMapper.insert(user);

            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId[(int) (i % 4)]);
            userRoleMapper.insert(userRole);
        }
    }
}
