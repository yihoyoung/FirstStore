package config;

/**
 * Created by hoyounglee on 2016. 5. 19..
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("loginForm");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("loginForm");
    }

}
