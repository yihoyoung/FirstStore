package org.store;

import java.util.Arrays;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@WebAppConfiguration
public class Application {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(Application.class, args);
    	
    	String[] beanNames = ctx.getBeanDefinitionNames();
    	Arrays.sort(beanNames);
    	for(String bean : beanNames){
    		System.out.println("======>" + bean);
    	}
    }
}