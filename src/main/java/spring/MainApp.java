package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.services.Printer;
import spring.services.Service;
import spring.services.ServiceImpl;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class })
public class MainApp {
    public static void main(String[] args) {
        SpringApplication bootApp = new SpringApplication(HelloWorldConfig.class);
        ConfigurableApplicationContext context = bootApp.run(args);

        Printer printer = context.getBean(Printer.class);
        printer.sendMessage();

        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();

        printer.sendMessage();

        Service service  = (Service) context.getBean(ServiceImpl.class);
        service.print();

        YAMLConfig config = context.getBean(YAMLConfig.class);
        System.out.println(config.getName());
        System.out.println(config.getVariable());
        System.out.println(config.isEnabled());
        System.out.println(config.getEnvironment());
        System.out.println(config.getServers().length);

    }
}