package wrx.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 请填写类的描述
 * 自定义负载规则
 * @author wangruxing
 * @date 2018-08-06 09:19
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myRule()
    {
        // 我自定义为每台机器3次
        return new MyRandomRule();
    }
}
