import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Test
 *
 * @author gongmin
 * @date 2023/4/7 14:28
 */
public class StreamTest {
    /**
     * 将所有元素大写化
     */
    @Test
    public void capitalize() {
        Stream<String> stream = Stream.of("gongmin", "jim", "lily", "2341Gm");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * 将元素合并
     */
    @Test
    public void combine() {
        Stream<String> stream = Stream.of("gongmin", "jim", "lily", "2341Gm");
        String data = stream.collect(Collectors.joining(","));
        System.out.println(data);
    }

    /**
     * 找出满足条件的元素
     */
    @Test
    public void filter() {
        Stream<User> userStream = Stream.of(
                User.builder()
                        .name("龚敏")
                        .age(35)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓迪")
                        .age(20)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓曦")
                        .age(18)
                        .gender("女")
                        .build()
        );

        userStream.filter(user -> "男".equals(user.getGender()))
                .map(user -> "名字：" + user.getName() + ", 年龄：" + user.getAge() + ", 性别：" + user.getGender())
                .forEach(System.out::println);
    }

    @Test
    public void sum() {
        Stream<User> userStream = Stream.of(
                User.builder()
                        .name("龚敏")
                        .age(35)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓迪")
                        .age(20)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓曦")
                        .age(18)
                        .gender("女")
                        .build()
        );

        int ageSum = userStream.filter(user -> "男".equals(user.getGender()))
                .mapToInt(User::getAge)
                .sum();

        System.out.println(ageSum);
    }

    @Test
    public void average() {
        Stream<User> userStream = Stream.of(
                User.builder()
                        .name("龚敏")
                        .age(35)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓迪")
                        .age(20)
                        .gender("男")
                        .build(),

                User.builder()
                        .name("龚晓曦")
                        .age(18)
                        .gender("女")
                        .build()
        );

        double ageSum = userStream.filter(user -> "男".equals(user.getGender()))
                .mapToInt(User::getAge)
                .average()
                .orElse(0);

        System.out.println(ageSum);
    }
}
