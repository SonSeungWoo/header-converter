package me.seungwoo;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-05
 * Time: 22:19
 */
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HeaderConverterApplication.class);
    }

}
