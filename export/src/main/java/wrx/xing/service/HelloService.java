package wrx.xing.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrx.xing.failback.HelloServiceFailBackFactory;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-06 13:42
 */
@FeignClient(value = "PROVIDER", fallbackFactory = HelloServiceFailBackFactory.class)
public interface HelloService {
    /**
     * hello 方法
     * @return
     */
    @RequestMapping("/provider/hello")
    String hello();

    /**
     * 除法运算方法
     * @param divisor
     * @param dividend
     * @return
     */
    @RequestMapping("/provider/div")
    Integer div(@RequestParam(value = "divisor") Integer divisor, @RequestParam(value = "dividend") Integer dividend);
}
