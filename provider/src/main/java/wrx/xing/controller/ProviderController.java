package wrx.xing.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-02 08:46
 */
@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProviderController {

    private Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private String port;
    @Value("${myName}")
    private String myName;

    @RequestMapping("/hello")
    @HystrixCommand
    public String hello(){
        return "hello springCloud I am " + myName + " my port is " + port;
    }

    @RequestMapping("/div")
    @HystrixCommand
    public Integer div(Integer divisor, Integer dividend){
        return divisor / dividend;
    }

    @RequestMapping("/test")
    @HystrixCommand
    public String test() throws InterruptedException {
        logger.info("test zuul retry...");
        Thread.sleep(1000000);
        return "test";
    }
}
