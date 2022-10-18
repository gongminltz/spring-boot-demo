import org.example.spring.boot.test.entity.User;
import org.example.spring.boot.test.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * UserService单元测试
 *
 * @author gongmin
 * @date 2022/10/18 15:53
 */
public class UserServiceTest extends BaseTest {
    @Resource
    private UserService userService;

    @Test
    public void getById() {
        String id = "1";
        User user = userService.getById(id);
        if (user == null) {
            logger.warn("<getById> 没有找到id为{}的用户", id);
        } else {
            logger.info("<getById> name = " + user.getName());
        }
    }
}
