import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * WebClient测试
 *
 * @author gongmin
 * @date 2023/3/3 10:02
 */
public class WebClientTest {
    /**
     * 非阻塞模式
     */
    @Test
    public void subscribe() {
        Mono<String> mono = WebClient
                .create("http://localhost:9100")
                .method(HttpMethod.GET)
                .uri("/test/helloWorld")
                .retrieve()
                .bodyToMono(String.class);
        mono.subscribe(WebClientTest::handleMonoResp);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 阻塞模式
     */
    @Test
    public void block() {
        Mono<String> mono = WebClient
                .create("http://localhost:9100")
                .method(HttpMethod.GET)
                .uri("/test/helloWorld")
                .retrieve()
                .bodyToMono(String.class);
        String result = mono.block();
        System.out.println("<block> result = " + result);
    }

    /**
     * 获取完整response，包含header，状态码等
     */
    @Test
    public void exchange() {
        Mono<ClientResponse> clientResponseMono = WebClient
                .create("http://localhost:9100")
                .method(HttpMethod.GET)
                .uri("/test/helloWorld")
                .exchange();

        ClientResponse clientResponse = clientResponseMono.block();

        // 响应头
        ClientResponse.Headers headers = clientResponse.headers();

        // 响应状态
        HttpStatus httpStatus = clientResponse.statusCode();

        // 响应状态码
        int rawStatusCode = clientResponse.rawStatusCode();

        // 响应体
        Mono<String> mono = clientResponse.bodyToMono(String.class);
        String body = mono.block();
        System.out.println("<exchange> body = " + body);
    }

    /**
     * 回调函数
     *
     * @param data 数据
     */
    private static void handleMonoResp(String data) {
        System.out.println("线程 = " + Thread.currentThread().getName() + ", 请求结果为：" + data);
    }
}
