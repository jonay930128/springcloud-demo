package wrx.xing;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-11-26 09:15
 */
@SpringBootApplication
@EnableAdminServer
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class,args);
	}
}
