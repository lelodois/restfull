package br.com.lelo.restfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RestFullApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFullApplication.class, args);
    }

}
