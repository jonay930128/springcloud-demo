package wrx.xing.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-11-26 08:02
 */
@Component
public class MyFallback implements FallbackProvider {

	private Logger logger = LoggerFactory.getLogger(MyFallback.class);

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		if (cause != null && cause.getCause() != null) {
			String reason = cause.getCause().getMessage();
			logger.info("Excption {}",reason);
		}
		return fallbackResponse();
	}

	@Override
	public String getRoute() {
		return "provider";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse(){

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("程序开小差,请稍后再试...".getBytes());
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}

			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}

			@Override
			public void close() {

			}
		};
	}
}
