package com.graduation.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.graduation.app.repository")
public class MyBatisConfig {
    
}
