package wrx.xing.failback;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wrx.xing.service.HelloService;

/**
 * 请填写类的描述
 * 失败应急类
 * @author wangruxing
 * @date 2018-08-07 09:16
 */
@Component
public class HelloServiceFailBackFactory implements FallbackFactory<HelloService> {
    private Logger logger = LoggerFactory.getLogger(HelloServiceFailBackFactory.class);

    public HelloService create(final Throwable throwable) {
        return new HelloService() {
            public String hello() {
                return "I am fail:" + throwable.getMessage();
            }

            public Integer div(Integer divisor, Integer dividend) {
                logger.error("div error:{}",throwable);
                return -1;
            }
        };
    }
}
