package com.rookie.webhomewrok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rookie.webhomewrok.mapper")
public class WebHomeWrokApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebHomeWrokApplication.class, args);
    }

}
