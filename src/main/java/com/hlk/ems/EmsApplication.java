package com.hlk.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hlk.ems.dao")
public class EmsApplication {


    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(EmsApplication.class, args);

    }

}
