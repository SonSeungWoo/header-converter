package me.seungwoo;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 16:03
 */
@Configuration
public class CustomFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info("filter start");
        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        String body = IOUtils.toString(requestWrapper.getBody(), request.getCharacterEncoding());
        servletRequest.setAttribute("requestBody", body);
        filterChain.doFilter(requestWrapper, servletResponse);
        logger.info("filter end");
    }
}
