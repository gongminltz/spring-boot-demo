import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class UserServiceTest {
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserInfo() {
        String id = "1";

        // 获取用户名打桩
        Mockito.when(userService.getName(id)).thenReturn("龚敏");

        // 获取电话号码打桩
        Mockito.when(userService.getPhone(id)).thenReturn("18824259722");

        Mockito.when(userService.getUserInfo(id)).thenCallRealMethod();

        UserInfo userInfo = userService.getUserInfo(id);

        Assertions.assertEquals("龚敏", userInfo.getName());
    }
}