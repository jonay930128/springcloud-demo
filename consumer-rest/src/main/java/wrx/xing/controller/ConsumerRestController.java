package wrx.xing.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-06 09:05
 */
@RestController
@RequestMapping("/consumerRest")
public class ConsumerRestController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String PROVIDER_PREFIX = "http://PROVIDER/";

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hystrixHello")
    public String hello(){
        String hello = restTemplate.getForObject(PROVIDER_PREFIX + "provider/div", String.class);
        return hello;
    }

    /**
     * 熔断
     * @return
     */
    private String hystrixHello(){
        return "hello hystrix";
    }
}
