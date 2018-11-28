package com.medicine;

import com.alibaba.fastjson.serializer.SerializerFeature;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.medicine.domain.mapper")
@EnableAutoConfiguration

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
