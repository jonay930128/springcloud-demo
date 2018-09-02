package wrx.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请填写类的描述
 * 服务消费者
 * @author wangruxing
 * @date 2018-08-06 09:01
 * @EnableDiscoveryClient 开启发现服务功能
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"wrx.xing"})
@ComponentScan("wrx.xing")
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }
}
