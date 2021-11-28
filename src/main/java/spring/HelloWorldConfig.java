package spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    public YAMLConfig config() {
        return new YAMLConfig();
    }

}
