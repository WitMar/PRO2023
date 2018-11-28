package spring;

import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }

    @Bean
    public Printer printer(){
        return new Printer();
    }
}
