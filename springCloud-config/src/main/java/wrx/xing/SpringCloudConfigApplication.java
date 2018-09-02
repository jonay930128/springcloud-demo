package wrx.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-15 21:11
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplication {
    /**
     * 主启动类
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class,args);
    }
}
