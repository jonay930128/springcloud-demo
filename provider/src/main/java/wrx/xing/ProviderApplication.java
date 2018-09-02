package wrx.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 请填写类的描述
 * 服务提供者
 * @author wangruxing
 * @date 2018-08-06 08:55
 */
@SpringBootApplication
@EnableCircuitBreaker
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
