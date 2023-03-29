import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

/**
 * WebClient测试
 *
 * @author gongmin
 * @date 2023/3/3 9:24
 */
public class WebClientTest {
    @Resource
    private WebClient webClient;

    @Test
    public void test() {
        webClient.get()
                .uri("https://www.qq.com")
                .retrieve()
                .toEntity(String.class)
                .flatMap(r1 -> webClient
                        .get().uri("https://www.baidu.com?a=" + r1.getBody())
                        .retrieve()
                        .toEntity(String.class)
                ).flatMap(r2 -> webClient
                        .get().uri("https://www.sina.com?a=" + r2.getBody())
                        .retrieve()
                        .toEntity(String.class)
                ).subscribe(r3 -> System.out.println(r3.getBody()));
    }
}
