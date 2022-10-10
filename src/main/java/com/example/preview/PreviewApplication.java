package com.example.preview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableSwagger2
public class PreviewApplication {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        SpringApplication.run(PreviewApplication.class, args);
        System.out.println("启动成功,耗时: " + (System.currentTimeMillis() - time) / 1000 +"s");
    }

}
