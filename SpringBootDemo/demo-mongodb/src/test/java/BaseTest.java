import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.mongodb.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试基础类
 *
 * @author gongmin
 * @date 2022/10/18 14:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected static final JsonMapper JSON_MAPPER = new JsonMapper();
}
