package info.atende.ssc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "info.atende.ssc")
public class ScalaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScalaSpringApplication.class, args);
    }
}
