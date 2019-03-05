package me.seungwoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 16:05
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CustomFilter customFilter;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
