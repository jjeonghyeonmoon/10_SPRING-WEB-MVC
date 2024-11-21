package com.ohgiraffers.crud.config;


// 빈 팩토리 == ioc 컨테이너 == 어플리케이션 컨텍스트

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.crud")
@MapperScan(basePackages = "com.ohgiraffers.crud", annotationClass = Mapper.class)
public class ContextConfig {

}
