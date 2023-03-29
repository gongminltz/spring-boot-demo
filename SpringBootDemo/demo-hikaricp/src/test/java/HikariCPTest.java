import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * HikariCPTest
 *
 * @author gongmin
 * @date 2023/3/29 15:22
 */
public class HikariCPTest {
    @Test
    public void testHikariCP() throws SQLException {
        // 1、创建Hikari配置
        HikariConfig hikariConfig = new HikariConfig();
        // JDBC连接串
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/gm1?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        // 数据库用户名
        hikariConfig.setUsername("gongmin");
        // 数据库用户密码
        hikariConfig.setPassword("gongmin");
        // 连接池名称
        hikariConfig.setPoolName("testHikari");
        // 连接池中最小空闲连接数量
        hikariConfig.setMinimumIdle(4);
        // 连接池中最大空闲连接数量
        hikariConfig.setMaximumPoolSize(8);
        // 连接在池中的最大空闲时间
        hikariConfig.setIdleTimeout(600000L);
        // 数据库连接超时时间
        hikariConfig.setConnectionTimeout(10000L);

        // 2、创建数据源
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        for (int i = 0; i < 10; i++) {
            // 3、获取连接
            Connection connection = dataSource.getConnection();

            // 4、获取Statement
            Statement statement = connection.createStatement();

            // 5、执行Sql
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) as countNum from role");

            // 6、输出执行结果
            if (resultSet.next()) {
                System.out.println("countNum结果为：" + resultSet.getInt("countNum"));
            }

            // 7、释放链接
            resultSet.close();
            statement.close();
            connection.close();
        }

        dataSource.close();
    }
}
