package spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import spring.services.Printer;

@SpringBootConfiguration
@ComponentScan
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    public Printer print() {
        return new Printer();
    }


    @Bean
    public YAMLConfig config() {
        return new YAMLConfig();
    }

}
