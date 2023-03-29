import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        MockedStatic mathUtils = Mockito.mockStatic(MathUtils.class);

        // 打桩
        mathUtils.when(() -> MathUtils.add(1, 2)).thenReturn(4);

        Assertions.assertEquals(3, MathUtils.add(1, 2));
    }

    @AfterEach
    void after() {
        System.out.println("测试完成");
    }
}