package org.cleartrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ClearTripApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(ClearTripApplication.class);
    }
}