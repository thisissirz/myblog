package com.whgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@MapperScan(basePackages ="com.whgc.mapper")
@SpringBootApplication
public class MyblogCombatApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyblogCombatApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(MyblogCombatApplication.class);
    }
}
