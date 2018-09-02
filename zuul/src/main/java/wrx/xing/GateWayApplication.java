package wrx.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-15 08:28
 */
@SpringBootApplication
@EnableZuulProxy
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
