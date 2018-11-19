package wrx.xing.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * 请填写类的描述
 * spring配置类，相当于applicationContext.xml
 * @author wangruxing
 * @date 2018-08-06 09:07
 */
@Configuration
public class ConfigBean {

    /**
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端   负载均衡的工具。
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    public AsyncRestTemplate getAsyncRestTemplate(){
        return new AsyncRestTemplate();
    }

    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
        //return new RandomRule();
//        return new RetryRule();
    }

}
