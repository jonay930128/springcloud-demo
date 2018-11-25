package wrx.xing.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-11-25 13:40
 */
public class PasswordFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(PasswordFilter.class);

	@Override
	public String filterType() {
		return "post"; // 请求处理完成后执行的filter
	}

	@Override
	public int filterOrder() {
		return 1; // 数字越大，优先级越低
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		// 判断上一个过滤器结果为true，否则就不走下面过滤器，直接跳过后面的所有过滤器并返回 上一个过滤器不通过的结果。
		return (boolean) ctx.get("isSuccess");
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info("--->>> PasswordFilter {},{}", request.getMethod(), request.getRequestURL().toString());

		String password = request.getParameter("password");
		if (Objects.equals(password,"123456")) {
			ctx.setSendZuulResponse(true);
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);
			return null;
		} else {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(400);
			ctx.setResponseBody("The password cannot be empty");
			ctx.set("isSuccess", false);
			return null;
		}
	}
}