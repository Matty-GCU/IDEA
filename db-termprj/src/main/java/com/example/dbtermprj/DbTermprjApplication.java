package com.example.dbtermprj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dbtermprj.mapper")
public class DbTermprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTermprjApplication.class, args);
	}

}
