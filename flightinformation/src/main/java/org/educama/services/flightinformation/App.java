package org.educama.services.flightinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
