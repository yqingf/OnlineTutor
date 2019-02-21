package com.aylfq5.online.tutor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @Description:    启动类
* @Author:         aylfq5
* @CreateDate:     2019/2/21 14:25
* @Version:        1.0
*/
@SpringBootApplication
@MapperScan("com.aylfq5.online.tutor.dao")
public class OnlineTutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTutorApplication.class, args);
	}

}
