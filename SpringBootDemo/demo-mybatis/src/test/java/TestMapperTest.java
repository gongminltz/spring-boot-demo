import com.fasterxml.jackson.databind.ser.Serializers;
import org.example.mybatis.mapper.TestMapper;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * TestMapperTest
 *
 * @author gongmin
 * @date 2023/4/28 9:55
 */
public class TestMapperTest extends BaseTest {
    @Resource
    private TestMapper testMapper;

    //@Transactional
    @Test
    public void getUuid() {
        String uuid1 = testMapper.getUUid();
        String uuid2 = testMapper.getUUid();

        logger.info("uuid1 = {}, uuid2 = {}", uuid1, uuid2);
    }
}
