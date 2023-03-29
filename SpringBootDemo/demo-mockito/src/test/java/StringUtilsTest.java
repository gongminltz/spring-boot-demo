import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void getSuffix() {
        Assertions.assertEquals("txt", StringUtils.getSuffix("1.txt"));
    }
}