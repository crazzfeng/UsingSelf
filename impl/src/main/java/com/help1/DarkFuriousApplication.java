package com.help1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(value="cn.darkFurious.mapper")
public class DarkFuriousApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarkFuriousApplication.class, args);
	}


	@RequestMapping("/log")
	public void  printLog(){
		long l = System.currentTimeMillis();
		System.err.println(l);
	}

}
