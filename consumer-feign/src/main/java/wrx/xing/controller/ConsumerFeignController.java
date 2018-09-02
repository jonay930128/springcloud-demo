package wrx.xing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrx.xing.service.HelloService;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-08-06 09:05
 */
@RestController
@RequestMapping("/consumerFeign")
public class ConsumerFeignController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        String hello = helloService.hello();
        return hello;
    }

    @RequestMapping("/div")
    public Integer div(Integer divisor, Integer dividend){
        return helloService.div(divisor,dividend);
    }
}
