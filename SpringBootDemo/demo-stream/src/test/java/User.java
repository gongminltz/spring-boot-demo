import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 *
 * @author gongmin
 * @date 2023/4/7 14:50
 */
@Getter
@Setter
@Builder
public class User {
    private String name;
    private int age;
    private String gender;
}
