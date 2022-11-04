import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.mongodb.entity.User;
import org.example.mongodb.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

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
    public void insert() {
        User user = User.builder()
                .id(2L)
                .name("lily")
                .phone("12341212")
                .address("万科白鹭郡")
                .build();

        userService.insert(user);
    }

    @Test
    public void findByName() throws JsonProcessingException {
        List<User> userList = userService.findByName("gongmin");
        logger.info("<findByName> userList = " + JSON_MAPPER.writeValueAsString(userList));
    }
}
