package ru.studentsplatform.endpoint;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Krylov Sergey (01.08.2020)
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		var request = RequestContext.getCurrentContext().getRequest();
		logger.info("----------------------------");
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		logger.info(request.getServerPort() + " " + request.getLocalPort() + " " + request.getRemotePort());
		logger.info("----------------------------");
		String pathInfo = request.getPathInfo();
		logger.info(pathInfo);
		return null;
	}
}