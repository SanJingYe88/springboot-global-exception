package it.com.sbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})    // 没有配置数据库
public class ExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }
}
