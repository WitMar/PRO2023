package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import spring.services.Service;
import spring.services.ServiceImpl;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();


        Printer printer  = (Printer) ctx.getBean(Printer.class);

        helloWorld.setMessage("Dzien dobry!");
        printer.sendMessage();

        Service service  = (Service) ctx.getBean(ServiceImpl.class);
        service.print();
    }
}