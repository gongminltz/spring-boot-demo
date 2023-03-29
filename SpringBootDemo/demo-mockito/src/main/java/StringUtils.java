/**
 * StringUtils
 *
 * @author gongmin
 * @date 2023/3/29 14:37
 */
public class StringUtils {
    public static String getSuffix(String data) {
        return data.substring(data.lastIndexOf(".") + 1);
    }
}
