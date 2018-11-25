package wrx.xing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wrx.xing.filter.ErrorFilter;
import wrx.xing.filter.PasswordFilter;
import wrx.xing.filter.TokenFilter;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-11-25 13:36
 */
@Configuration
public class ZuulConfig {

//	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}

//	@Bean
	public PasswordFilter passwordFilter() {
		return new PasswordFilter();
	}

//	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}
}
