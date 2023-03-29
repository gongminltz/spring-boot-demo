/**
 * UserService
 *
 * @author gongmin
 * @date 2023/3/29 14:49
 */
public class UserService {
    public UserInfo getUserInfo(String id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(getName(id));
        userInfo.setPhone(getPhone(id));

        return userInfo;
    }

    public String getName(String id) {
        return null;
    }

    public String getPhone(String id) {
        return null;
    }
}
