package config;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@ComponentScan({"config","controller", "domain", "repository", "service"})
public class Application {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}